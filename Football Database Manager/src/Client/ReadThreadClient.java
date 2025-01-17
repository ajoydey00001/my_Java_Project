package Client;
import util.NetworkUtil;
import util.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ReadThreadClient implements Runnable{
   private Thread thr;
   private NetworkUtil networkUtil;
   private Main main;

   public ReadThreadClient(NetworkUtil networkUtil,Main m) {
       this.networkUtil = networkUtil;
       this.main = m;
       this.thr = new Thread(this);
       thr.start();
   }

   @Override
    public void run() {
       try {
           while (main.getFlag()!=2) {
               Object o = networkUtil.read();
               if(o instanceof ArrayList) {
                   main.setBuyPlayerList(new ArrayList<>((Collection<Player>)o));
               }
               else if(o instanceof Player) {
                   Player p = (Player) o;
                   double d = p.getSellrate();
                   if((int) d < 0)
                       main.removePlayer(p);
               }
           }
       } catch (Exception e) {
           System.out.println(e);
       } finally {
           try {
               networkUtil.closeConnection();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
}

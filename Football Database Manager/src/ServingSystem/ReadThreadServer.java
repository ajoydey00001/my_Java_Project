package ServingSystem;

import util.NetworkUtil;
import util.Player;
import java.io.IOException;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    private Server main;
    private String name;

    public ReadThreadServer(NetworkUtil networkUtil,String name,Server main) {
        this.name = name;
        this. main = main;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }
    @Override
    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                 if(o instanceof Player) {
                    Player obj = (Player) o;
                    main.updateBuyList(obj);
                }
                if(o instanceof String) {
                    String s = (String) o;
                    if(s.equalsIgnoreCase("BuyingRequest")) {

                        main.buying(networkUtil,name);

                    }
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




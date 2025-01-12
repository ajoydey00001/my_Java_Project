package ServingSystem;

import util.NetworkUtil;
import util.Player;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Server {
    private List<Player> playerList;
    private List<Player> buyPlayerList;
    public Player buyplayer = null;
    private ServerSocket serverSocket;
    public HashMap<String, NetworkUtil> clientMap;


    public void readFromFile() throws Exception {
        playerList = new ArrayList<>();
        buyPlayerList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("D:\\CSE_108\\1905038 (1)\\Football Database Manager\\src\\ServingSystem\\players.txt"));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player s = new Player();
            s.setName(tokens[0]);
            s.setCountry(tokens[1]);
            s.setAge(Integer.parseInt(tokens[2]));
            s.setHeight(Double.parseDouble(tokens[3]));
            s.setClub(tokens[4]);
            s.setPosition(tokens[5]);
            s.setNumber(Integer.parseInt(tokens[6]));
            s.setWeeklysalary(Double.parseDouble(tokens[7]));
            double d = Double.parseDouble(tokens[8]);
            s.setSellrate(d);
            playerList.add(s);
            if((int)d > 0) buyPlayerList.add(s);
        }
        br.close();

    }
    
    
    public List<Player> getClientPlayerList(String s) {
        List<Player> list = new ArrayList<>();
        for(Player p : playerList) {
            if(p.getClub().equalsIgnoreCase(s)){
                list.add(p);
            }
        }
        return list;
    }
   public synchronized void buying(NetworkUtil networkUtil,String s) {

        List<Player> list = new ArrayList<>();
        for(Player p : buyPlayerList) {
            if(!p.getClub().equalsIgnoreCase(s)){
                list.add(p);
            }
        }
        try {
            networkUtil.write(list);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Object o = networkUtil.read();
            if (o instanceof Player) {
                buyplayer = (Player) o;
                Player h = null;
                for(Player g : buyPlayerList) {
                    if(g.getName().equalsIgnoreCase(buyplayer.getName())) {
                        h = g;
                        break;
                    }
                }
                buyPlayerList.remove(h);
                try {
                    String to = buyplayer.getClub();
                    NetworkUtil nu = clientMap.get(to);
                    if (nu != null) {
                        nu.write(buyplayer);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                buyplayer = null;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

   }
   public void updateBuyList(Player p) {
        boolean k = true;
        for(Player s : buyPlayerList) {
            if(s.getName().equalsIgnoreCase(p.getName())) {
                s.setSellrate(p.getSellrate());
                k = false;
            }
        }
        if(k) {
            buyPlayerList.add(p);
        }
   }
    Server() {
        clientMap = new HashMap<>();
        try {
            readFromFile();
            serverSocket = new ServerSocket(44444);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        String clientName = (String) networkUtil.read();
        clientMap.put(clientName, networkUtil);
        List<Player> p = getClientPlayerList(clientName);
        networkUtil.write(p);
        new ReadThreadServer(networkUtil, clientName,this);

    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}

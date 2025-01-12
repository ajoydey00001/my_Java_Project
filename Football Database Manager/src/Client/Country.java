package Client;

import java.util.ArrayList;
import util.Player;
import java.util.List;

public class Country {
    private String name;
    private List<Player> playerList ;
    private int count = 0;
    public Country() { playerList = new ArrayList() ; }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Player p)
    {
        playerList.add(p);
        count++;
    }
    public void removePlayer(Player p) {
        Player q = null;
        for(Player s : playerList) {
            if(s.getName().equalsIgnoreCase(p.getName())){
                q = s;
                break;
            }
        }
        playerList.remove(q);
        count--;
    }
    public int getCount(){
        return count;
    }
    public List<Player> getPlayerList(){
        return playerList;
    }

}

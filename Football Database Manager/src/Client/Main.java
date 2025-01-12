package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.NetworkUtil;
import util.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Main extends Application {
    private List<Player> playerList;
    private List<Player> buyPlayerList = null;
    private int flag;
    private String name;
    private NetworkUtil networkUtil;
    public Stage stage;
    private List<Country> countrys;

    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        flag = 0;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        LoginController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void Initialize(String name) throws Exception {
        networkUtil = new NetworkUtil("127.0.0.1",44444);
        this.name = name;
        try{
            networkUtil.write(name);
           Object o = networkUtil.read();
           if(o instanceof ArrayList) {
               playerList = new ArrayList<>((Collection<Player>)o);
           }
            new ReadThreadClient(networkUtil,this);

        } catch (Exception e) {
            System.out.println(e);
        }
        countrys = new ArrayList<>();
        for(Player s : playerList){

            boolean k= true;
            for(Country j : countrys)
            {
                if(j.getName().equalsIgnoreCase(s.getCountry()))
                {
                    k=false;
                    j.addPlayer(s);
                    break;
                }
            }
            if(k)
            {
                Country t = new Country();
                t.setName(s.getCountry());
                t.addPlayer(s);
                countrys.add(t);
            }
        }
        showMainMenuPage();
    }

    public void showMainMenuPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Main Menu.fxml"));
        Parent root = loader.load();
        MainMenuController controller = loader.getController();
        controller.init("Main Menu Page Of "+ name);
        controller.setMain(this);
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }

    public void showClubPlayerListPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ClubPlayerList.fxml"));
        Parent root = loader.load();
        ClubPlayerListController controller = loader.getController();
        controller.load(playerList);
        controller.setMain(this);
        stage.setTitle("Club Player List");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }
    public void showClubPlayerListAlertPage(String message) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ClubPlayerListAlert.fxml"));
        Parent root = loader.load();
        ClubPlayerListAlertControl controller = loader.getController();
        controller.init(message);
        controller.setMain(this);
        stage.setTitle("Club Player List Alert");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showPlayerSearchingOptionPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PlayerSearchingOption.fxml"));
        Parent root = loader.load();
        PlayerSearchingOptionController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Player Searching Option");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }
    public void showPlayerSearchingAlertPage(String message) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PlayerSearchingAlert.fxml"));
        Parent root = loader.load();
        PlayerSearchingAlertControl controller = loader.getController();
        controller.init(message);
        controller.setMain(this);
        stage.setTitle("Player Searching Alert");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showClubSearchingOptionPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ClubSearchingOption.fxml"));
        Parent root = loader.load();
        ClubSearchingOptionController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Club Searching Option");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }

    public void showSellingPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Selling.fxml"));
        Parent root = loader.load();
        SellingController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Selling");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showBuyingPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BuyPlayerList.fxml"));
        Parent root = loader.load();
        BuyPlayerListController controller = loader.getController();
        controller.load(buyPlayerList);
        controller.setMain(this);
        stage.setTitle("Buy Player List");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }
    public void showByPlayerPage(String message) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ByPlayer.fxml"));
        Parent root = loader.load();
        ByPlayerController controller = loader.getController();
        controller.init(message);
        controller.setMain(this);
        stage.setTitle("System");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showFromPlayerListPage(List<Player> list) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FromPlayerList.fxml"));
        Parent root = loader.load();
        FromPlayerListController controller = loader.getController();
        controller.load(list);
        controller.setMain(this);
        stage.setTitle("From Player List");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }
    public void showByCountryClubPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ByCountryClub.fxml"));
        Parent root = loader.load();
        ByCountryClubController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Country And Club");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showByPositionPage(String message) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ByPosition.fxml"));
        Parent root = loader.load();
        ByPositionController controller = loader.getController();
        controller.init(message);
        controller.setMain(this);
        stage.setTitle("System");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showByRangeSalaryPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ByRangeSalary.fxml"));
        Parent root = loader.load();
        ByRangeSalaryController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Weekly Salary Range");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showCountrywisePlayerCountPage(List<Country> list) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CountrywisePlayerCount.fxml"));
        Parent root = loader.load();
        CountrywisePlayerCountController controller = loader.getController();
        controller.load(list);
        controller.setMain(this);
        stage.setTitle("Country-wise Players Count");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }
    public void showFromClubPage(List<Player> list) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FromClub.fxml"));
        Parent root = loader.load();
        FromClubController controller = loader.getController();
        controller.load(list);
        controller.setMain(this);
        stage.setTitle("From Club");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }
    public void showTotalPage(String message) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Total.fxml"));
        Parent root = loader.load();
        TotalController controller = loader.getController();
        controller.init(message);
        controller.setMain(this);
        stage.setTitle("Total Yearly Salary Of This Club");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void searchClub4() throws Exception{
        double t=0.0;
        for(Player s : playerList){
            t+= s.getWeeklysalary();
        }
         t*=52;
        showTotalPage("Total Yearly Salary Of All Players Of  "+name.toUpperCase()+" :  "+t);
    }
    public void searchClub3() throws Exception{
        List<Player> s = new ArrayList<>();
        Player t = playerList.get(0);
        for(Player j : playerList){
            if(t.getHeight()<j.getHeight())
            {
                t=j;
            }
        }
        for(Player j : playerList){
            if(t.getHeight()==j.getHeight())
            {
                s.add(j);
            }
        }
        showFromClubPage(s);
    }
    public void searchClub2() throws Exception{
        List<Player> s = new ArrayList<>();
        Player t = playerList.get(0);
        for(Player j : playerList){
            if(t.getAge()<j.getAge())
            {
                t=j;
            }
        }
        for(Player j : playerList){
            if(t.getAge()==j.getAge())
            {
                s.add(j);
            }
        }
        showFromClubPage(s);
    }
    public void searchClub1() throws Exception{
        List<Player> s = new ArrayList<>();
        Player t = playerList.get(0);
        for(Player j : playerList){
            if(t.getWeeklysalary()<j.getWeeklysalary())
            {
                t=j;
            }
        }
        for(Player j : playerList){
            if(t.getWeeklysalary()==j.getWeeklysalary())
            {
                s.add(j);
            }
        }
            showFromClubPage(s);
    }
    public List<Country> searchPlayer5(){
        return countrys;
    }
    public List<Player> searchPlayer4(double d1,double d2){
        List<Player> list = new ArrayList<>();
        for(Player s : playerList){
            if(d1<= s.getWeeklysalary() && s.getWeeklysalary()<= d2){
                list.add(s);
            }
        }
        return list;
    }
    public List<Player> searchPlayer3(String p){
        List<Player> list = new ArrayList<>();
        for(Player s : playerList){
            if(s.getPosition().equalsIgnoreCase(p)){
                list.add(s);
            }
        }
        return list;
    }
    public List<Player> searchPlayer2(String p){
        List<Player> list = new ArrayList<>();
        for(Player s : playerList){
            if(s.getCountry().equalsIgnoreCase(p)){
                list.add(s);
            }
        }
        return list;
    }
    public List<Player> searchPlayer1(String p){
        List<Player> list = new ArrayList<>();
        for(Player s : playerList){
            if(s.getName().equalsIgnoreCase(p)){
                list.add(s);
                return list;
            }
        }
        return list;
    }
    public void buying() {
        buyPlayerList = null;
        try {
            networkUtil.write("BuyingRequest");
        } catch (Exception e) {
            System.out.println(e);
        }

        while(getBuyPlayerList() == null){

        }
        if(buyPlayerList.isEmpty()) {
            try {
                networkUtil.write("There is no player in the BuyPlayerList");
                showClubPlayerListAlertPage("Error ! There Is No Player To Buy ");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            try {
                showBuyingPage();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void addPlayer(Player p, double d) {
           p.setSellrate(d);
           Player q = new Player(p.getName(),p.getCountry(), p.getAge(),p.getHeight(),p.getClub(),p.getPosition(),p.getNumber(),p.getWeeklysalary(),p.getSellrate() * (-1.0)) ;
                try {
                    networkUtil.write(q);
                } catch (Exception e) {
                    System.out.println(e);
                }
        p.setClub(name);
        playerList.add(p);
            boolean k= true;
            for(Country j : countrys)
            {
                if(j.getName().equalsIgnoreCase(p.getCountry()))
                {
                    k=false;
                    j.addPlayer(p);
                    break;
                }
            }
            if(k)
            {
                Country t = new Country();
                t.setName(p.getCountry());
                t.addPlayer(p);
                countrys.add(t);
            }

    }
    public void selling(String s,double d) {
        for(Player q : playerList){
            if(q.getName().equalsIgnoreCase(s)){
                q.setSellrate(d);
                try {
                    networkUtil.write(q);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return ;
            }
        }
    }
    public List<Player> getPlayerList() {
        return playerList;
    }
    public void setBuyPlayerList(List<Player> l) {
        this.buyPlayerList = l;
    }
    public void setFlag(int i) {
        this.flag = i;
    }
    public int getFlag(){
        return flag;
    }
    public List<Player> getBuyPlayerList() {
        return buyPlayerList;
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
        for(Country c : countrys) {
            if(c.getName().equalsIgnoreCase(p.getCountry())) {
                c.removePlayer(p);
                if(c.getCount()==0) {
                    countrys.remove(c);
                }
                break;
            }
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}

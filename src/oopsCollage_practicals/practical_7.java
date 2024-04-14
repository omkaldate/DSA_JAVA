package oopsCollage_practicals;

class  Inherit {
    String name;
    int age;

    public void setPlayerInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayPlayerInfo() {
        System.out.println(" Player Name:  " + name);
        System.out.println(" Player Age:  " + age);
    }
}

class CricketPlayer extends Inherit{
    String role ;
    public void setCricketPlayerInfo (String name , int age , String role){
        setPlayerInfo(name,age);
        this.role = role  ;
    }
    public void displayCricketPlayerInfo(){
        displayPlayerInfo();
        System.out.println("Cricket Role:  " +  role);
    }
}

class FootballPlayer extends Inherit {
    String position;
    public void setFootballPlayerInfo(String name , int age , String position){
        setPlayerInfo(name , age);
        this.position = position;
    }
    public void displayFootballPlayerInfo(){
        displayPlayerInfo();
        System.out.println("Football Position:  " + position);
    }
}

class HockeyPlayer extends Inherit{
    String position;
    public void setHockeyPlayerInfo(String name,int age,String position){
        setPlayerInfo(name,age);
        this.position = position;
    }
    public void displayHockeyPlayerInfo(){
        displayPlayerInfo();
        System.out.println("Hockey Position:  " + position);
    }

}
public class practical_7 {
    public static void main  (String[]  args){
        System.out.println("Name :  Om Balasaheb Kaldate");
        System.out.println();
        CricketPlayer cricketPlayer = new CricketPlayer();
        FootballPlayer footballPlayer = new FootballPlayer();
        HockeyPlayer hockeyPlayer = new HockeyPlayer();
        cricketPlayer.setCricketPlayerInfo("Dhoni ",7,"Batsman");
        footballPlayer.setFootballPlayerInfo("CristianoRonaldo", 34,"Suiiii Forward");
        hockeyPlayer.setHockeyPlayerInfo("Dhyan Chand ",114,"Forward");
        System.out.println("Cricket Player Information: ");
        cricketPlayer.displayCricketPlayerInfo();
        System.out.println("\n Football Player Information: ");
        footballPlayer.displayFootballPlayerInfo  ();
        System.out.println("\n Hockey Player Information: ");
        hockeyPlayer.displayHockeyPlayerInfo();
    }
}



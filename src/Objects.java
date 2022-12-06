import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class Objects {
    File casinoStart= new File(System.getProperty("user.dir")+"\\src\\casinoStart.png");
    File enemyAceSpades= new File(System.getProperty("user.dir")+"\\src\\enemyAceSpades.png");
    File enemyJackClubs= new File(System.getProperty("user.dir")+"\\src\\enemyJackClubs.png");
    File enemyKingDiamonds= new File(System.getProperty("user.dir")+"\\src\\enemyKingDiamonds.png");
    File enemyQueenHearts= new File(System.getProperty("user.dir")+"\\src\\enemyQueenHearts.png");
    File enemyRoyalFlush= new File(System.getProperty("user.dir")+"\\src\\enemyRoyalFlush.png");
    Creature guard = new Creature("Guard",25,7,2,10,25,null);//Half of base player Stats
    Creature kingDiamonds = new Creature("King of Diamonds", 45, 12, 5, 50, 80,enemyKingDiamonds); //Middling Health, high speed, high luck
    Creature queenHearts = new Creature("Queen of Hearts",75,10,5,20,50,enemyQueenHearts);//High Health, High Defense, low attack
    Creature jackClubs= new Creature("Jack of Clubs",20,15,5,20,25,enemyJackClubs);//High attack, low health, low luck
    Creature aceSpades= new Creature("Ace of Spades",50,12,5,20,50,enemyAceSpades);//Stats equal to base level player
    Creature royalFlush = new Creature("?????",200,35,10,50,65,enemyRoyalFlush);//Takes 10 hits to kill with maxed equipment, takes him 5 to kill with maxed equipment

    Creature player = new Creature("Player",50,15,5,20,50,null); //End Stats become H: 100, A: 30 D:15, S:40, L: 80

    Item diamondBoots= new Item("diamond boots",0,0,0,20,10,false);
    Item heartsArmor = new Item("hearts armor",25,0,5,0,10,false);
    Item clubsClub = new Item("clubs club",0,15,0,0,10,false);
    Item spadesShield = new Item("spades shield",25,0,5,0,0,false);
    String entranceInfo = "There is an entrance";
    String lobbyInfo = "There is an lobby";
    String diamondInfo = "There is an diamond";
    String heartsInfo = "There is an heart";
    String clubsInfo = "There is an club";
    String spadesInfo = "There is an spade";
    String hallwayInfo = "There is an hallway";
    String royalFlushInfo = "There is an royal flush";

    File hallway= new File(System.getProperty("user.dir")+"\\src\\hallway.wav");
    File victory= new File(System.getProperty("user.dir")+"\\src\\victory.wav");
    File kingRoom= new File(System.getProperty("user.dir")+"\\src\\kingRoom.wav");
    File queenRoom= new File(System.getProperty("user.dir")+"\\src\\queenRoom.wav");
    File jackRoom= new File(System.getProperty("user.dir")+"\\src\\jackRoom.wav");
    File finalBattle= new File(System.getProperty("user.dir")+"\\src\\finalBattle.wav");



    File roomClubs= new File(System.getProperty("user.dir")+"\\src\\roomClubs.png");
    File roomDiamonds= new File(System.getProperty("user.dir")+"\\src\\roomDiamonds.png");
    File roomHearts= new File(System.getProperty("user.dir")+"\\src\\roomHearts.png");
    File roomLobby= new File(System.getProperty("user.dir")+"\\src\\roomLobby.png");
    File roomSpades= new File(System.getProperty("user.dir")+"\\src\\roomSpades.png");

    Room entranceRoom = new Room("Entrance",guard,null,entranceInfo,null,casinoStart);
    Room lobbyRoom = new Room("Lobby",null,null,lobbyInfo,null,roomLobby);
    Room diamondRoom = new Room("King Of Diamonds Room",kingDiamonds,diamondBoots,diamondInfo,kingRoom,roomDiamonds);
    Room heartsRoom = new Room("Queen of Hearts Room",queenHearts,heartsArmor,heartsInfo,queenRoom,roomHearts);
    Room clubsRoom = new Room("Jack of Clubs Room",jackClubs,clubsClub,clubsInfo,jackRoom,roomClubs);
    Room spadesRoom = new Room("Ace of Spades Room",aceSpades,spadesShield,spadesInfo,jackRoom,roomSpades);
    Room hallwayRoom = new Room("Hallway",null,null,hallwayInfo,hallway,roomLobby);
    Room royalFlushRoom = new Room(royalFlush.getName()+"'s room",royalFlush,null,royalFlushInfo,finalBattle,roomLobby);
    Room[] roomArray = {entranceRoom,lobbyRoom,diamondRoom,heartsRoom,clubsRoom,spadesRoom,hallwayRoom,royalFlushRoom};

    public Objects() throws IOException {
    }

    public File getVictory() {
        return victory;
    }

    public Room[] getRoomArray() {
        return roomArray;
    }

    public Creature getPlayer() {
        return player;
    }
}
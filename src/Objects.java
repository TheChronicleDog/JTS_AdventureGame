import java.util.HashMap;


public class Objects {
    Creature guard = new Creature("Guard",25,7,2,10,25);//Half of base player Stats
    Creature kingDiamonds = new Creature("King of Diamonds", 45, 12, 5, 50, 80); //Middling Health, high speed, high luck
    Creature queenHearts = new Creature("Queen of Hearts",75,10,5,20,50);//High Health, High Defense, low attack
    Creature jackClubs= new Creature("Jack of Clubs",20,15,5,20,25);//High attack, low health, low luck
    Creature aceSpades= new Creature("Ace of Spades",50,12,5,20,50);//Stats equal to base level player
    Creature royalFlush = new Creature("?????",200,35,10,50,65);//Takes 10 hits to kill with maxed equipment, takes him 5 to kill with maxed equipment

    Creature player = new Creature("Player",50,15,5,20,50); //End Stats become H: 100, A: 30 D:15, S:40, L: 80

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

    Room entranceRoom = new Room("Entrance",guard,null,entranceInfo);
    Room lobbyRoom = new Room("Lobby",null,null,lobbyInfo);
    Room diamondRoom = new Room("King Of Diamonds Room",kingDiamonds,diamondBoots,diamondInfo);
    Room heartsRoom = new Room("Queen of Hearts Room",queenHearts,heartsArmor,heartsInfo);
    Room clubsRoom = new Room("Jack of Clubs Room",jackClubs,clubsClub,clubsInfo);
    Room spadesRoom = new Room("Ace of Spades Room",aceSpades,spadesShield,spadesInfo);
    Room hallwayRoom = new Room("Hallway",null,null,hallwayInfo);
    Room royalFlushRoom = new Room(royalFlush.getName()+"'s room",royalFlush,null,royalFlushInfo);
    Room[] roomArray = {entranceRoom,lobbyRoom,diamondRoom,heartsRoom,clubsRoom,spadesRoom,hallwayRoom,royalFlushRoom};

    public Room[] getRoomArray() {
        return roomArray;
    }

    public Creature getPlayer() {
        return player;
    }
}
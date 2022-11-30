import java.util.HashMap;


public class Objects {
    Creature guard = new Creature("Guard",25,7,2,10,25);//Half of base player Stats
    Creature kingDiamonds = new Creature("King of Diamonds", 45, 12, 5, 50, 80); //Middling Health, high speed, high luck
    Creature queenHearts = new Creature("Queen of Hearts",75,10,5,20,50);//High Health, High Defense, low attack
    Creature jackClubs= new Creature("Jack of Clubs",20,15,5,20,25);//High attack, low health, low luck
    Creature aceSpades= new Creature("Ace of Spades",50,12,5,20,50);//Stats equal to base level player
    Creature royalFlush = new Creature("?????",200,35,10,50,65);//Takes 10 hits to kill with maxed equipment, takes him 5 to kill with maxed equipment

    Creature player = new Creature("Player",50,15,5,20,50); //End Stats become H: 100, A: 30 D:15, S:40, L: 80

    Item diamondKey = new Item("diamond key");
    Item heartsKey = new Item("hearts key");
    Item clubsKey = new Item("clubs key");
    Item spadesKey = new Item("spades key");

    Room entranceRoom = new Room("Entrance",guard,null);
    Room lobbyRoom = new Room("Lobby",null,null);
    Room diamondRoom = new Room("King Of Diamonds Room",kingDiamonds,null);
    Room heartsRoom = new Room("Queen of Hearts Room",queenHearts,null);
    Room clubsRoom = new Room("Jack of Clubs Room",jackClubs,null);
    Room spadesRoom = new Room("Ace of Spades Room",aceSpades,null);
    Room hallwayRoom = new Room("Hallway",null,null);
    Room royalFlushRoom = new Room("???? Room",royalFlush,null);
    Room[] roomArray = {entranceRoom,lobbyRoom,diamondRoom,heartsRoom,clubsRoom,spadesRoom,hallwayRoom,royalFlushRoom};

    public Room[] getRoomArray() {
        return roomArray;
    }

    public Creature getPlayer() {
        return player;
    }
}
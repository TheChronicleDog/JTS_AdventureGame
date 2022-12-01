public class Room {
    String roomName;
    Creature enemy;
    Item item;
    String information;
    Room(){
        this("empty",null,null,"empty");
    }
    Room(String roomName,Creature enemy, Item item,String information){
        this.roomName = roomName;
        this.enemy = enemy;
        this.item = item;
        this.information = information;
    }

    public void setEnemy(Creature enemy) {
        this.enemy = enemy;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Creature getEnemy() {
        return enemy;
    }

    public Item getItem() {
        return item;
    }

    public String getInformation() {
        return information;
    }

    public String getRoomName() {
        return roomName;
    }
}


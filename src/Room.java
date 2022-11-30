public class Room {
    String roomName;
    Creature enemy;
    Item item;
    Room(){
        this("empty",null,null);
    }
    Room(String roomName,Creature enemy, Item item){
        this.roomName = roomName;
        this.enemy = enemy;
        this.item = item;
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

    public String getRoomName() {
        return roomName;
    }
}


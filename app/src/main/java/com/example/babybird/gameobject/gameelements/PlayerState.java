package com.example.babybird.gameobject.gameelements;

public class PlayerState {
    public enum State {
        FLYING_FRONT,
        FLYING_BACKWARD,
        FALLING_DOWN
    }
    private Player player;
    private State state;
    public PlayerState(Player player){
        this.player=player;
        this.state= State.FLYING_FRONT;

    }
    public State getState() {
        return state;
    }
    public void update(){
        switch (state){
            case FLYING_FRONT:
                if(player.direction()==false) state=State.FLYING_BACKWARD;
                break;
            case FLYING_BACKWARD:
                if(player.direction()==true) state=State.FLYING_FRONT;
                break;
            /*case FALLING_DOWN:
                if(player.direction()==false) state=State.FLYING_BACKWARD;
                break;*/
            default:
                break;
        }
    }
}

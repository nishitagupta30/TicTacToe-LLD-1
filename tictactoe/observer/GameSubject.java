package tictactoe.observer;

import java.util.ArrayList;
import java.util.List;
import tictactoe.Game;

public abstract class GameSubject {
    private List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer){
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(GameObserver observer : observers){
            observer.update((Game) this);
        }
    }

}

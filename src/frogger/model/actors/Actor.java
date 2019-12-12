package frogger.model.actors;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

import frogger.model.World;

/**
 * @author scyyx1
 * Represents an actor class to present some common methods that an actor type may use.
 * Contains methods like move object, get world, get intersecting object and act.
 */
public abstract class Actor extends ImageView{


    /**
     * Get the parent object of current actor.
     * @return The current world.
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Check whether two objects are intersecting with each other.
     * @param <A> A type A which extends the Actor
     * @param cls The class with Actor type. 
     * @return An intersecting list.
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }


    

    
    

}

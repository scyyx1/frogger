package frogger.model;


import java.util.ArrayList;
import java.util.List;

import frogger.model.actors.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


/**
 * @author scyyx1
 * Represent a class that included some methods for world to use.
 */
public abstract class World extends Pane {
	
    /**
     * An animation timer for start and stop the world.
     */
    private AnimationTimer timer;
    
    /**
     * A constructor to initialize the world.
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
     * Create and initialize timer for the world.
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * Call the create timer method, and start the timer.
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * Stop the timer.
     */
    public void stop() {
        timer.stop();
    }
    
    /**
     * Add the actor type into the view.
     * @param actor The object that wants to be added.
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Remove the actor type in the view.
     * @param actor The object that wants to be removed.
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    
    /**
     * Get the lists of certain object.
     * @param <A> Type A which extends the Actor type.
     * @param cls Class name of certain type.
     * @return The lists of certain object.
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
            
        }
        return someArray;
    }

    
    /**
     * The action of certain objects.
     * @param now
     */
    public abstract void act(long now);
}

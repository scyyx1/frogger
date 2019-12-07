package com.scyyx1.frogger.view;

import com.scyyx1.frogger.model.GameWorld;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HelpWindow extends Pane{

	public HelpWindow() {
		Button again = new Button("again");

		getChildren().add(again);
	}
}

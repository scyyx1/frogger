package com.scyyx1.frogger.view;

import com.scyyx1.frogger.model.MyStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class HelpWindow extends MyStage{

	public HelpWindow() {
		Button again = new Button("again");

		getChildren().add(again);
	}
}

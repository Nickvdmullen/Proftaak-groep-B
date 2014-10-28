/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.javafx.scene.control.behavior;
 
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.scene.traversal.Direction;

import static javafx.scene.input.KeyCode.*;

/**
 *
 * @author Mal
 */
public class BehaviourBase {
     public class BehaviorBase<C extends Control> {
          private C control;
          private List<KeyBinding> keyBindings = createKeyBindings();
     }
    protected static final List<KeyBinding> TRAVERSAL_BINDINGS = new ArrayList<KeyBinding>();
     static {
        TRAVERSAL_BINDINGS.add(new KeyBinding(UP, "TraverseUp"));
        TRAVERSAL_BINDINGS.add(new KeyBinding(DOWN, "TraverseDown"));
        TRAVERSAL_BINDINGS.add(new KeyBinding(LEFT, "TraverseLeft"));
        TRAVERSAL_BINDINGS.add(new KeyBinding(RIGHT, "TraverseRight"));
        TRAVERSAL_BINDINGS.add(new KeyBinding(TAB, "TraverseNext"));
        TRAVERSAL_BINDINGS.add(new KeyBinding(TAB, "TraversePrevious").shift());

       TRAVERSAL_BINDINGS.add(new KeyBinding(UP, "TraverseUp").shift().alt().ctrl());
        TRAVERSAL_BINDINGS.add(new KeyBinding(DOWN, "TraverseDown").shift().alt().ctrl());
         TRAVERSAL_BINDINGS.add(new KeyBinding(LEFT, "TraverseLeft").shift().alt().ctrl());
         TRAVERSAL_BINDINGS.add(new KeyBinding(RIGHT, "TraverseRight").shift().alt().ctrl());
         TRAVERSAL_BINDINGS.add(new KeyBinding(TAB, "TraverseNext").shift().alt().ctrl());
         TRAVERSAL_BINDINGS.add(new KeyBinding(TAB, "TraversePrevious").alt().ctrl());
     }
 
     protected static final List<KeyBinding> EMPTY_BINDINGS = new ArrayList<KeyBinding>();
     
    
      protected List<KeyBinding> createKeyBindings() {
      return EMPTY_BINDINGS;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.javafx.scene.control.behavior;

import com.sun.javafx.Utils;
import static com.sun.javafx.scene.control.behavior.OptionalBoolean.ANY;
import static com.sun.javafx.scene.control.behavior.OptionalBoolean.FALSE;
import static com.sun.javafx.scene.control.behavior.OptionalBoolean.TRUE;
import com.sun.javafx.tk.Toolkit;
import javafx.event.EventType;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 *
 * @author Mal
 */
public class KeyBinding {
    private KeyCode code;
    private EventType<KeyEvent> eventType = KeyEvent.KEY_PRESSED;
    private String action;
    private OptionalBoolean shift = FALSE;
    private OptionalBoolean ctrl = FALSE;
    private OptionalBoolean alt = FALSE;
    private OptionalBoolean meta = FALSE;

    public KeyBinding(KeyCode code, String action) {
       this.code = code;
       this.action = action;
    }
    
    public KeyBinding(KeyCode code, EventType<KeyEvent> type, String action) {
        this.code = code;
        this.eventType = type;
        this.action = action;
    }
    
    public KeyBinding shift() {
         return shift(TRUE);
     }
 
     public KeyBinding shift(OptionalBoolean value) {
        shift = value;
         return this;
    }

    public KeyBinding ctrl() {
        return ctrl(TRUE);
    }

   public KeyBinding ctrl(OptionalBoolean value) {
       ctrl = value;
       return this;
   }
 
   public KeyBinding alt() {
         return alt(TRUE);
   }
 
   public KeyBinding alt(OptionalBoolean value) {
       alt = value;
       return this;
   }
   
   public KeyBinding meta() {
       return meta(TRUE);
    }

    public KeyBinding meta(OptionalBoolean value) {
        meta = value;
        return this;
    }
    
    public KeyBinding shortcut() {
        if (Toolkit.getToolkit().getClass().getName().endsWith("StubToolkit")) {
            // FIXME: We've hit the terrible StubToolkit (which only appears 
            // during testing). We will dumb down what we do here
          if (Utils.isMac()) {
              return meta();
          } else {
              return ctrl();
          }
      } else {
          switch (Toolkit.getToolkit().getPlatformShortcutKey()) {
              case SHIFT:
                  return shift();

              case CONTROL:
                  return ctrl();

              case ALT:
                  return alt();

              case META:
                  return meta();

                default:
                  return this;
          }
      }
  }

  public final KeyCode getCode() { return code; }
  public final EventType<KeyEvent> getType() { return eventType; }
  public final String getAction() { return action; }
  public final OptionalBoolean getShift() { return shift; }
    public final OptionalBoolean getCtrl() { return ctrl; }
  public final OptionalBoolean getAlt() { return alt; }
  public final OptionalBoolean getMeta() { return meta; }

  public int getSpecificity(Control control, KeyEvent event) {
      int s = 0;
      if (code != null && code != event.getCode()) return 0; else s = 1;
      if (!shift.equals(event.isShiftDown())) return 0; else if (shift != ANY) s++;
      if (!ctrl.equals(event.isControlDown())) return 0; else if (shift != ANY) s++;
      if (!alt.equals(event.isAltDown())) return 0; else if (shift != ANY) s++;
        if (!meta.equals(event.isMetaDown())) return 0; else if (shift != ANY) s++;
      if (eventType != null && eventType != event.getEventType()) return 0; else s++;
      // We can now trivially accept it
      return s;
  }

  @Override 
  public String toString() {
      return "KeyBinding [code=" + code + ", shift=" + shift +
              ", ctrl=" + ctrl + ", alt=" + alt + 
              ", meta=" + meta + ", type=" + eventType + 
                ", action=" + action + "]";
  }
}


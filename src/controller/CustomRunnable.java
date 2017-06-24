package controller;

import java.awt.event.MouseEvent;

/**
 * A Runnable that can accept a mouse event.
 */
interface CustomRunnable extends Runnable {
  void receiveEvent(MouseEvent e);
}

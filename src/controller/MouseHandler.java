package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 */
class MouseHandler implements MouseListener {
  private CustomRunnable clickedRun;

  @Override
  public void mouseClicked(MouseEvent e) {
    clickedRun.receiveEvent(e);
    clickedRun.run();
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  public void addMouseClicked(CustomRunnable run) {
    clickedRun = run;
  }
}

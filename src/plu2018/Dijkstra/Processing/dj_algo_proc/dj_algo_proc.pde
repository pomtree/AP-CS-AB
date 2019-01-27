int w, h;
DJ dj;
void setup () {
  size(650, 650);
  background(0);
  w = 25;
  h = 25;
  boolean blocked[][]  = new boolean[h][w];
  for (int j = 0; j < 7; j++) {
    int rw = (int)(Math.random() * w);
    int rh = (int)(Math.random() * h);
    for (int i = 0; i < 40; i++) {
      blocked[rh][rw] = true;
      rh += (int)random(-2, 2);
      rw += (int)random(-2, 2);
      rh = max(min(rh, h - 1), 0);
      rw = max(min(rw, w - 1), 0);
    }
  }

  frameRate(40);
  dj = new DJ(w, h, (int)random(0, w), (int)random(0, h), 10, 10, blocked);
}
void draw() {
  background(0);
  dj.update_neighbors();
  if (!dj.reassign_current()) {
    delay(1000);

    int cs = dj.grid[dj.end_y][dj.end_x].score;
    int cx = dj.end_x;
    int cy = dj.end_y;
    while (cs > 0) {

      cs--;
      println("target score = " + cs);
      //try down
      if (cy + 1 < h && dj.grid[cy + 1][cx].score == cs) {
        cy++;
      }
      //try up
      else if (cy -1 > 0 && dj.grid[cy - 1][cx].score == cs) {
        //try left
        cy--;
      } else if (cx + 1 < w && dj.grid[cy][cx+ 1].score == cs) {
        cx++;
      }
      //try right
      else {
        cx--;
      }
      fill(255);
      dj.grid[cy][cx].en_route = true;
      println(cx * width/w + "," + cy * height / h);
      ellipse(cx * width/w, cy * height / h, 10, 10);
    }



    delay(1000);
    //setup();
  }
  dj.display();
  println("current: (" + dj.cx + "," + dj.cy + ")");
}
void keyPressed() {
  background(0);
  dj.update_neighbors();
  println("new current? " +   dj.reassign_current());
  dj.display();
  println("current: (" + dj.cx + "," + dj.cy + ")");
  if (key == 'r')
    setup();
}
void mouseClicked() {
  int x = w*mouseX/width;
  int y =h*mouseY/height;
  dj.grid[y][x].is_blocked = ! dj.grid[y][x].is_blocked;
  dj.display();
  println("(un)blocking (" + x + "," + y + ")");
}

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class noiseLandscape extends PApplet {

//separate each logic per each scope
int noiseDet1;
int noiseDet2;
int noiseDet3;
int noiseDet4;
int noiseDet5;
float noiseFall1;
float noiseFall2;
float noiseFall3;
float noiseFall4;
float noiseFall5;

float[] verts;
float[] noiseVals;
int numVert1;
int vert1siz = 500; 

float[] verts2;
float[] noiseVals2;
int numVert2;
int vert2siz = 320; 

float[] verts3;
float[] noiseVals3;
int numVert3;
int vert3siz = 340; 

float[] verts4;
float[] noiseVals4;
int numVert4;
int vert4siz = 360; 

float[] verts5;
float[] noiseVals5;
int numVert5;
int vert5siz = 380; 

float gradientSpacing = 1; 
float gradientAngling = 4;
float gradientLoops = 12;
float inc = 0; 
float loopColorMod = 2; 

int backgroundVal = 230; 
int valueIncrement = 20;


public void setup() {
  //gradient loops: 0 - 150
  //gradient angling: -100 - 100
  //gradient spacing: -2 - 5
  //background val: 40 - 240
  //loop color mod: -3 - 10
  //value increment: -40 - 100

  gradientSpacing = 1 + randomGaussian() * 3;//random(-2, 5); 
  gradientAngling = 4 + randomGaussian() * 90;//random(-100, 100);
  gradientLoops = max(1, (int)(12 + randomGaussian() * 120));//(int)random(0, 150);
  inc = random(10, 10000); 
  loopColorMod = 2 + randomGaussian() * 6;//random(-3, 10); 

  backgroundVal = (int)random(40, 240); 
  valueIncrement = (int)random(-40, 100);

  noiseDet1 = (int)random(5, 8);
  noiseDet2 = (int)random(4, 8);
  noiseDet3 = (int)random(3, 8);
  noiseDet4 = (int)random(2, 8);
  noiseDet5 = (int)random(2, 8);

  noiseFall1 = random(0.0f, 0.5f);
  noiseFall2 = random(0.0f, 0.5f);
  noiseFall3 = random(0.0f, 0.5f);
  noiseFall4 = random(0.0f, 0.5f);
  noiseFall5 = random(0.0f, 0.5f);

  
  //pixelDensity(2);
  
  background(230); 
  numVert1 = vert1siz;
  verts = new float[vert1siz];
  noiseVals = new float[vert1siz];
  numVert2 = vert2siz;
  verts2 = new float[vert2siz];
  noiseVals2 = new float[vert2siz];
  numVert3 = vert3siz;
  verts3 = new float[vert3siz];
  noiseVals3 = new float[vert3siz];
  numVert4 = vert4siz;
  verts4 = new float[vert4siz];
  noiseVals4 = new float[vert4siz];
  numVert5 = vert5siz;
  verts5 = new float[vert5siz];
  noiseVals5 = new float[vert5siz];
  noiseDetail(8, 0.5f);
  
  drawEverything();
  drawEverything();
  drawEverything();
  drawEverything();
  drawEverything();
  save("output.png");
  exit();
}



public void draw() {

}


public void drawEverything() {
  background(backgroundVal); 
  noStroke();


  noiseDetail(noiseDet1, noiseFall1);
  for (int j = 0; j < gradientLoops; j++)  {
    fill(200-(j*loopColorMod));
    beginShape();
    float xval1 = 0; 
    for (int i = 0; i < verts.length; i++) {
      xval1 = map(i, 0, verts.length-1, 0, width+(i));
      vertex(xval1-j*gradientAngling+i, noiseVals[i]+(j*gradientSpacing));
    }
    vertex(xval1, height);
    vertex(-10, height);
    vertex(-10, noiseVals[0]);
    endShape(CLOSE);
  }

  noiseDetail(noiseDet2, noiseFall2);
  for (int j = 0; j < gradientLoops; j++) {
    fill(200-(valueIncrement*1)-(j*loopColorMod));
    beginShape();
    float xval2 = 0; 
    for (int i = 0; i < verts2.length; i++) {
      xval2 = map(i, 0, verts2.length-1, 0, width+(i));
      vertex(xval2-j*gradientAngling+i, noiseVals2[i]+(j*gradientSpacing));
    }
    vertex(xval2, height);
    vertex(-10, height);
    vertex(-10, noiseVals2[0]);
    endShape(CLOSE);
  }

  noiseDetail(noiseDet3, noiseFall3);
  for (int j = 0; j < gradientLoops; j++) {
    fill(200-(valueIncrement*2)-(j*loopColorMod));
    beginShape();
    float xval3 = 0; 
    for (int i = 0; i < verts3.length; i++) {
      xval3 = map(i, 0, verts3.length-1, 0, width+(i));
      vertex(xval3-j*gradientAngling+i, noiseVals3[i]+(j*gradientSpacing));
    }
    vertex(xval3, height);
    vertex(-10, height);
    vertex(-10, noiseVals3[0]);
    endShape(CLOSE);
  }

  noiseDetail(noiseDet4, noiseFall4);
  for (int j = 0; j < gradientLoops; j++) {
    fill(200-(valueIncrement*3)-(j*loopColorMod));
    beginShape();
    float xval4 = 0; 
    for (int i = 0; i < verts4.length; i++) {
      xval4 = map(i, 0, verts4.length-1, 0, width+(i));
      vertex(xval4-j*gradientAngling+i, noiseVals4[i]+(j*gradientSpacing));
    }
    vertex(xval4, height);
    vertex(-10, height);
    vertex(-10, noiseVals4[0]);
    endShape(CLOSE);
  }

  noiseDetail(noiseDet5, noiseFall5);
  for (int j = 0; j < gradientLoops; j++) {
    fill(200-(valueIncrement*4)-(j*loopColorMod));
    beginShape();
    float xval5 = 0; 
    for (int i = 0; i < verts5.length; i++) {
      xval5 = map(i, 0, verts5.length-1, 0, width+(i));
      vertex(xval5-j*gradientAngling+i, noiseVals5[i]+(j*gradientSpacing));
    }
    vertex(xval5, height);
    vertex(-10, height);
    vertex(-10, noiseVals5[0]);
    endShape(CLOSE);
  }
  updateMountains();
  //save("output.png");
  //exit();
}



//press different keys to generate different kinds of landscapes
public void updateMountains() {
  inc+=1;

  noiseDetail(noiseDet1, noiseFall1);
  for (int i = 0; i < numVert1; i++) {
    noiseVals[i] = height/2+(noise(i*0.01f+(inc*0.0001f)) * (height*.5f));
  }
  noiseDetail(noiseDet2, noiseFall2);
  for (int i = 0; i < numVert2; i++) {
    noiseVals2[i] = height/2+40+(noise(i*0.01f+1000+(inc*0.0005f)) * (height*.45f));
  }
  noiseDetail(noiseDet3, noiseFall3);
  for (int i = 0; i < numVert3; i++) {
    noiseVals3[i] = height/2+80+(noise(i*0.01f+2000+(inc*0.001f)) * (height*.4f));
  }
  noiseDetail(noiseDet4, noiseFall4);
  for (int i = 0; i < numVert4; i++) {
    noiseVals4[i] = height/2+120+(noise(i*0.01f+3000+(inc*.005f)) * (height*.35f));
  }
  noiseDetail(noiseDet5, noiseFall5);
  for (int i = 0; i < numVert5; i++) {
    noiseVals5[i] = height/2+160+(noise(i*0.01f+4000+(inc*.01f)) * (height*.3f));
  }
  //println(frameRate);
} 

public void keyPressed() {
  if (key == 's') {
    saveFrame(frameCount+".png");
  }
  if (key == 'z') {
    vert1siz += 100; 
    println(vert1siz);
  }

  //gradient loops: 0 - 150
  //gradient angling: -100 - 100
  //gradient spacing: -2 - 5
  //background val: 40 - 240
  //loop color mod: -3 - 10
  //value increment: -40 - 100
  if (key == CODED) {  
    if (keyCode == UP) {
      gradientLoops++; 
      println("gradientLoops: " + gradientLoops);
    }
    if (keyCode == DOWN) {
      gradientLoops--; 
      println("gradientLoops: " + gradientLoops);
    }
    if (keyCode == RIGHT) {
      gradientAngling+= 0.1f; 
      println("gradientAngling: " + gradientAngling);
    }
    if (keyCode == LEFT) {
      gradientAngling-= 0.1f; 
      println("gradientAngling: " + gradientAngling);
    }
  }
  if (key == 'm') {
    gradientSpacing += .1f; 
    println("gradientSpacing: " + gradientSpacing);
  }
  if (key == 'n') {
    gradientSpacing -= .1f; 
    println("gradientSpacing: " + gradientSpacing);
  }
  if (key == 'k') {
    backgroundVal--; 
    println("backgroundVal: " + backgroundVal);
  }
  if (key == 'l') {
    backgroundVal++; 
    println("backgroundVal: " + backgroundVal);
  }
  if (key == 'o') {
    loopColorMod -= .1f; 
    println("loopColorMod: " + loopColorMod);
  }
  if (key == 'p') {
    loopColorMod += .1f; 
    println("loopColorMod: " + loopColorMod);
  }
  if (key == '.') {
    valueIncrement ++; 
    println("valueIncrement: " + valueIncrement);
  }
  if (key == ',') {
    valueIncrement --; 
    println("valueIncrement: " + valueIncrement);
  }
}
  public void settings() {  size(1200, 600, P2D);  noSmooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "noiseLandscape" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

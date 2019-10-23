package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
//texturas
import java.io.File;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Dimension;
import java.io.IOException;

public class Escenario implements GLEventListener {

    private Texture Terreno, Estrellas, Casa, puerta,  Sendero, Montaña2,Montaña;

    public static void main(String[] args) {
        Frame frame = new Frame("Escenario");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Escenario());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        gl.glEnable(GL.GL_CULL_FACE);
        //Establecemos la ruta de la textura y la variable que tomara dicha textura
        try {
            //Se indica la localizacion de la figura                
            Terreno = TextureIO.newTexture(new File("src/org/yourorghere/Nieve.jpg"), true);
            Estrellas = TextureIO.newTexture(new File("src/org/yourorghere/Estrellas.jpg"), true);
            Casa = TextureIO.newTexture(new File("src/org/yourorghere/Ladrillos.jpg"), true);
            puerta = TextureIO.newTexture(new File("src/org/yourorghere/Puerta_Madera.jpg"), true);
            Sendero = TextureIO.newTexture(new File("src/org/yourorghere/Sendero.jpg"), true);
            Montaña2 = TextureIO.newTexture(new File("src/org/yourorghere/Tapiz_regalo.png"), true);
            Montaña = TextureIO.newTexture(new File("src/org/yourorghere/Montaña.jpg"), true);
        } catch (IOException e) {
            System.err.print("No se puede cargar textura" + e);
            System.exit(1);
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        gl.glTexEnvi(gl.GL_TEXTURE_ENV, gl.GL_TEXTURE_ENV_MODE, gl.GL_DECAL);
        gl.glLoadIdentity();
        // Move the "drawing cursor" around

        gl.glPushMatrix();
        gl.glPushMatrix();
        // Draw A Quad
        gl.glTranslatef(0.0f, -2.5f, -6.0f);
        Terreno.enable();
        Terreno.bind();

        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(-3.5f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(3.5f, 0f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(3.5f, 3.0f, 0.0f);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(-3.5f, 3.0f, 0.0f);
        // Done Drawing The Quad
        gl.glEnd();
        Terreno.disable();
              
        gl.glTranslatef(0.0f, 3.0f, 0.0f);
//        gl.glTranslatef(0.0f, 3.0f, 0.0f);
        Estrellas.enable();
        Estrellas.bind();

        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(-3.5f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(3.5f, 0f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(3.5f, 3.0f, 0.0f);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(-3.5f, 3.0f, 0.0f);
        // Done Drawing The Quad
        gl.glEnd();
        Estrellas.disable();

       
        
        gl.glTranslatef(1.0f, -0.5f, 0.0f);
        Casa.enable();
        Casa.bind();
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(0f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(1f, 0f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(1f, 1f, 0.0f);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(0f, 1f, 0.0f);
        // Done Drawing The Quad
        gl.glEnd();
        Casa.disable();

        gl.glTranslatef(1.0f, 0.0f, 0.0f);
        Casa.enable();
        Casa.bind();
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(0f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(0.5f, 0.5f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(0.5f, 1.5f, 0.0f);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(0f, 1f, 0.0f);
        // Done Drawing The Quad
        gl.glEnd();
        Casa.disable();

        gl.glTranslatef(-1.0f, 1.0f, 0.0f);
        Casa.enable();
        Casa.bind();
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(0f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(1f, 0f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(1.5f, 0.5f, 0.0f);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(0.5f, 0.5f, 0.0f);
        // Done Drawing The Quad
        gl.glEnd();
        Casa.disable();

        gl.glTranslatef(0.3f, -1.0f, 0.0f);
        gl.glScalef(0.8f, 0.8f, 0.8f);
        puerta.enable();
        puerta.bind();
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(0f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(0.5f, 0f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(0.5f, 1f, 0.0f);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(0f, 1f, 0.0f);
        // Done Drawing The Quad
        gl.glEnd();
        puerta.disable();

        gl.glTranslatef(-0.6f, -3.6f, 0.0f);
        Sendero.enable();
        Sendero.bind();
        gl.glScalef(1f, 1.8f, 1f);
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(-0.5f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(0.5f, 0f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(1f, 2f, 0.0f);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(0.5f, 2f, 0.0f);
        // Done Drawing The Quad
        gl.glEnd();
        Sendero.disable();

        gl.glTranslatef(-2.0f, 2.0f, 0.0f);
        gl.glPushMatrix();
        gl.glScalef(0.5f, 0.5f, 0.5f);
        Montaña2.enable();
        Montaña2.bind();
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(-0.6f, 0f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(1f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(0.6f, 3.5f, 0.0f);
        // Done Drawing The Quad
        gl.glEnd();
        Montaña2.disable();

        gl.glTranslatef(1.0f, 0.0f, 0.0f);
        gl.glTranslatef(-1.0f, 1.0f, 0.0f);
        gl.glTranslatef(-2.0f, -3.0f, 0.0f);
    
        Montaña.enable();
        Montaña.bind();
        gl.glBegin(GL.GL_TRIANGLES);
        
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(-0.6f, 0f, 0.0f);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(1f, 0f, 0.0f);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(0.6f, 3.5f, 0.0f);
        
        gl.glEnd();
        
        
        
        gl.glTranslatef(-3.0f, 4.0f, 0.0f);
        double Pi=3.14159265358979323846;
        Montaña.enable();
        Montaña.bind();
         gl.glBegin(gl.GL_POLYGON);
            for(int i=0; i<100; i++){
               gl.glTexCoord2f(i, i);
               float x = (float) Math.cos(i*2*Pi/50);
               float y = (float) Math.sin(i*2*Pi/50);
               gl.glVertex2f(x, y); 
               
            }
        gl.glEnd();
        
        gl.glPopMatrix();

      
        gl.glPopMatrix();
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

}

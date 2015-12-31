import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.*;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Drawcube extends Object {

	private float angle = 0;
    private float length;
    private float xAngle;
    private float yAngle;
    private float zAngle;
    private float translate;

    public Drawcube(float l, float xAngle, float yAngle, float zAngle, float translate) {
        this.length = l;
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.zAngle = zAngle;
        this.translate = translate;
    }

    public void draw(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        /*int iTexture = 0;
        try {
	        File file = new File("/bin/data/poney.jpg");
	        Texture texture = TextureIO.newTexture(file, true);
	        iTexture = texture.getTextureObject(gl);
        }catch(IOException ex) {
        	ex.printStackTrace();
        }*/
        
        /*gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glBindTexture(GL2.GL_TEXTURE_2D, iTexture);*/

        gl.glLoadIdentity();
        gl.glPushMatrix();

        gl.glTranslatef(0, this.translate, 0);

        /* Handle cube's rotation in the plane {z = 0} around the origin at a distance of distRotCenter from the cube
        orbAngle = (orbAngle + this.orbSpeed) % 360f;
        float x = (float) cos(toRadians(orbAngle)) * this.orbDist;
        float y = (float) sin(toRadians(orbAngle)) * this.orbDist;
        gl.glTranslatef(x, y, 0);*/

        gl.glRotatef(this.angle, this.xAngle, this.yAngle, this.zAngle);

        // Start quadrilateral drawing
        gl.glBegin(GL2.GL_QUADS);

        //int counter = 0;
        
        /*switch(counter) {
        case 0: gl.glTexCoord2d(0, 0);
        break;
        case 1: gl.glTexCoord2d(1, 0);
        break;
        case 2: gl.glTexCoord2d(1, 1);
        break;
        case 3: gl.glTexCoord2d(0, 1);
        break;
        }*/
        
        // Back
        gl.glColor3f(1, 0, 0);
        gl.glVertex3f(this.length, -this.length, this.length);
        gl.glVertex3f(-this.length, -this.length, this.length);
        gl.glVertex3f(-this.length, this.length, this.length);
        gl.glVertex3f(this.length, this.length, this.length);

        // Bottom
        gl.glColor3f(1, .5f, 0);
        gl.glVertex3f(this.length, -this.length, this.length);
        gl.glVertex3f(-this.length, -this.length, this.length);
        gl.glVertex3f(-this.length, -this.length, -this.length);
        gl.glVertex3f(this.length, -this.length, -this.length);

        // Left
        gl.glColor3f(0, 0, 1);
        gl.glVertex3f(-this.length, -this.length, this.length);
        gl.glVertex3f(-this.length, -this.length, -this.length);
        gl.glVertex3f(-this.length, this.length, -this.length);
        gl.glVertex3f(-this.length, this.length, this.length);

        // Right
        gl.glColor3f(1, 0, .5f);
        gl.glVertex3f(this.length, this.length, -this.length);
        gl.glVertex3f(this.length, this.length, this.length);
        gl.glVertex3f(this.length, -this.length, this.length);
        gl.glVertex3f(this.length, -this.length, -this.length);

        // Top
        gl.glColor3f(0, 1, 0);
        gl.glVertex3f(this.length, this.length, -this.length);
        gl.glVertex3f(-this.length, this.length, -this.length);
        gl.glVertex3f(-this.length, this.length, this.length);
        gl.glVertex3f(this.length, this.length, this.length);

        // Front
        gl.glColor3f(1, 1, 0);
        gl.glVertex3f(-this.length, -this.length, -this.length);
        gl.glVertex3f(this.length, -this.length, -this.length);
        gl.glVertex3f(this.length, this.length, -this.length);
        gl.glVertex3f(-this.length, this.length, -this.length);

        /*if (++counter > 3)
        	counter = 0;*/
        
        gl.glEnd();

        gl.glPopMatrix();
    }
    
    public void update() {
    	this.angle+=1;
    }
}

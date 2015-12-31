import java.awt.*;
import com.jogamp.newt.event.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;
import com.jogamp.opengl.util.*;

public class Scene {

	public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(capabilities);

        Frame frame = new Frame("Cubes");
        frame.setSize(700, 700);
        frame.add(canvas);
        frame.setVisible(true);

        // Draw cubes
        Drawcube cube1 = new Drawcube(.08f,-1f, 0, 0, 0.65f);
        Drawcube cube2 = new Drawcube(0.12f, -1,  0, 0, 0.25f);
        Drawcube cube3 = new Drawcube(.15f,-1f, 0, 0, -0.25f);

        Render renderCube = new Render();

        renderCube.addCube(cube1);
        renderCube.addCube(cube2);
        renderCube.addCube(cube3);

        canvas.addGLEventListener(renderCube);

        final FPSAnimator animator = new FPSAnimator(canvas, 30);
        // Start the animation
        animator.start();

        /*
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });*/
    }
}

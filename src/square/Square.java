package square;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Square {
    
    public Square() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable To Initilialize GLFW");
        }
        
        long win = glfwCreateWindow(800, 600, "Hello World!", NULL, NULL);
        if (win == NULL) {
            glfwTerminate();
            throw new RuntimeException("Failed To Create The GLFW Window");
        }
        
        glfwMakeContextCurrent(win);
        GL.createCapabilities();
        
        while (!glfwWindowShouldClose(win)) {
            double time = glfwGetTime();
            glfwSwapBuffers(win);
            glfwPollEvents();
            
            if(glfwGetKey(win, GLFW_KEY_ESCAPE) == GL_TRUE) {
                glfwSetWindowShouldClose(win, true);
            }
        }
        
        glfwDestroyWindow(win);
        glfwTerminate();
    }
    
    public static void main(String[] args) {
        new Square();
    }    
}

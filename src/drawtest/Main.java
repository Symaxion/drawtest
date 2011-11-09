/*
 * Drawtest Library
 * Copyright (C) 2011 Frank "SeySayux" Erens <seysayux@gmail.com>
 *
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 *   1. The origin of this software must not be misrepresented; you must not
 *   claim that you wrote the original software. If you use this software
 *   in a product, an acknowledgment in the product documentation would be
 *   appreciated but is not required.
 *
 *   2. Altered source versions must be plainly marked as such, and must not be
 *   misrepresented as being the original software.
 *
 *   3. This notice may not be removed or altered from any source
 *   distribution.
 *   
 */

package drawtest;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        Canvas cv = new Canvas("Test",160,90);
        cv.addShape("agrid",new Grid(Color.gray));
        cv.addShape("line1", new Line(new Point(35,27),(float)(30*Math.PI/180),10,Color.CYAN));
        cv.addShape("circle1", new Circle(new Point(50,50), 8.0f,Color.green));
        
    }

}

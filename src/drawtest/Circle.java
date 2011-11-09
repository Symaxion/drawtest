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

/**
 *
 * @author Frank "SeySayux" Erens <seysayux@gmail.com>
 */
public class Circle extends Shape {

    Point loc;
    float radius;
    Color c;

    Circle(Point loc, float radius, Color c) {
        this.loc = loc;
        this.radius = radius;
        this.c = c;
    }

    Circle(Point loc, Point p2, Color c) {
        this.loc = loc;
        this.radius = (float) Math.sqrt(Math.pow(loc.x - p2.x, 2)+
                Math.pow(loc.y - p2.y,2));
        this.c = c;
    }

    @Override
    public void paint(Painter p) {
        // x*x + y*y = r*r; thus y = sqrt(r*r - x*x)
        for(int x = 0; x < Math.ceil(radius); x++) {
            p.put(new Point(loc.x+x, loc.y+(int)Math.round(Math.sqrt(radius * radius
                    - x*x))), c);
            p.put(new Point(loc.x-x, loc.y+(int)Math.round(Math.sqrt(radius * radius
                    - x*x))), c);
            p.put(new Point(loc.x+x, loc.y-(int)Math.round(Math.sqrt(radius * radius
                    - x*x))), c);
            p.put(new Point(loc.x-x, loc.y-(int)Math.round(Math.sqrt(radius * radius
                    - x*x))), c);
        }
        // x*x + y*y = r*r; thus x = sqrt(r*r - y*y)
        for(int y = 0; y < Math.ceil(radius); y++) {
            p.put(new Point(loc.x + (int)Math.round(Math.sqrt(radius * radius
                    - y*y)),loc.y + y), c);
            p.put(new Point(loc.x - (int)Math.round(Math.sqrt(radius * radius
                    - y*y)),loc.y + y), c);
            p.put(new Point(loc.x + (int)Math.round(Math.sqrt(radius * radius
                    - y*y)),loc.y - y), c);
            p.put(new Point(loc.x - (int)Math.round(Math.sqrt(radius * radius
                    - y*y)),loc.y - y), c);

        }
    }

}

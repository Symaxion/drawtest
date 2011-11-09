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
public class Line extends Shape {

    private Point a;
    private Point b;
    private Color c;

    Line(Point a, Point b, Color c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Line(Point a, float angle, int length, Color c) {
        this.a = a;
        this.b = new Point(a.x + (int)Math.round(Math.cos(angle)*length),
                a.y - (int)Math.round(Math.sin(angle)*length));
        this.c = c;

    }

    @Override
    public void paint(Painter p) {
        p.put(a, c);
        p.put(b, c);
        // okay, let's do the math...
        int dx = b.x - a.x;
        int dy = b.y - a.y;
        if (Math.abs(dx) > Math.abs(dy)) {
            // flat
            float slope = ((float) dy / (float) dx);
            int step = dx > 0 ? 1 : -1;
            for (int x = 0; x != dx; x += step) {
                p.put(new Point(a.x + x, Math.round(slope * x + a.y)), c);
            }
        } else {
            // steep
            // flat
            float slope = ((float) dx / (float) dy);
            int step = dy > 0 ? 1 : -1;
            for (int y = 0; y != dy; y += step) {
                p.put(new Point(Math.round(slope * y + a.x),a.y + y), c);
            }
        }

        

    }
}

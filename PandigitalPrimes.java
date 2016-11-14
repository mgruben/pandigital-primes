/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pandigitalprimes;

import java.util.Arrays;

/**
 * Finds the largest n-digit pandigital prime.
 * 
 * A number is n-digit pandigital if it makes use of the digits 1 through n
 * exactly once.
 * @author Michael <GrubenM@GMail.com>
 */
public class PandigitalPrimes {
    
    /**
     * Is the given string of digits pandigital?
     * @param s
     * @return 
     */
    public boolean isPandigital(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != i+1 + '0') return false;
        }
        return true;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PandigitalPrimes p = new PandigitalPrimes();
        System.out.println(p.isPandigital("214"));
    }
}

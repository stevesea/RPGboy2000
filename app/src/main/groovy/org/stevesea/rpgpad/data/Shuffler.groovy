/*
 * Copyright (c) 2016 Steve Christensen
 *
 * This file is part of RPG-Pad.
 *
 * RPG-Pad is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RPG-Pad is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RPG-Pad.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.stevesea.rpgpad.data

import groovy.transform.CompileStatic

import javax.inject.Inject

@CompileStatic
class Shuffler {
    final Random random;

    @Inject
    Shuffler(Random random) {
        this.random = random
    }

    def pick(List<?> items) {
        return items.get(random.nextInt(items.size()))
    }

    List<?> pickN(List<?> items, int num) {
        def local = items.collect()
        Collections.shuffle(local, random)
        return local.take(num)
    }

    int rollDice(Integer numDice, Integer nSides) {
        return Dice.roll(numDice, nSides, 0, random)
    }
}

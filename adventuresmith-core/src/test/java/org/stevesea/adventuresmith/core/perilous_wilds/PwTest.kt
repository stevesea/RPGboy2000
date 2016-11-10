/*
 * Copyright (c) 2016 Steve Christensen
 *
 * This file is part of Adventuresmith.
 *
 * Adventuresmith is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Adventuresmith is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Adventuresmith.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.stevesea.adventuresmith.core.perilous_wilds

import org.junit.*
import org.stevesea.adventuresmith.core.*
import java.util.*

class PwTest {

    @Test
    fun treasure_item() {
        Assert.assertEquals("key/lockpick".trimIndent(),
                getGenerator(PwConstants.TREASURE_ITEM, 0).generate(Locale.US))
    }

    @Test
    fun treasure_unguarded() {
        Assert.assertEquals("""
        <p>A useful item - potion/food
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Adjective:</small></strong> rough/hard/sharp
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Age:</small></strong> young/recent
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Oddity:</small></strong> geometric</p>
        """.trimIndent(),
                getGenerator(PwConstants.TREASURE_UNGUARDED, 1).generate(Locale.US))
    }


    @Test
    fun treasure_guarded1() {
        Assert.assertEquals("""
        <h5>damage die - D4 + 1d4</h5>
        <p>A useful item - key/lockpick
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Adjective:</small></strong> slick/slimy
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Age:</small></strong> being born/built
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Oddity:</small></strong> weird color/smell/sound</p>

        <h5>damage die - D6 + 1d4</h5>
        <p>A useful item - key/lockpick
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Adjective:</small></strong> slick/slimy
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Age:</small></strong> being born/built
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Oddity:</small></strong> weird color/smell/sound</p>

        <h5>damage die - D8 + 1d4</h5>
        <p>A useful item - key/lockpick
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Adjective:</small></strong> slick/slimy
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Age:</small></strong> being born/built
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Oddity:</small></strong> weird color/smell/sound</p>

        <h5>damage die - D10 + 1d4</h5>
        <p>A useful item - key/lockpick
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Adjective:</small></strong> slick/slimy
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Age:</small></strong> being born/built
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Oddity:</small></strong> weird color/smell/sound</p>

        <h5>damage die - D12 + 1d4</h5>
        <p>A useful item - key/lockpick
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Adjective:</small></strong> slick/slimy
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Age:</small></strong> being born/built
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Oddity:</small></strong> weird color/smell/sound</p>
        """.trimIndent(),
                getGenerator(PwConstants.TREASURE_GUARDED_1BONUS, 0).generate(Locale.US))
    }
    @Test
    fun npc() {
        Assert.assertEquals("""
        <h4>NPC Wilderness</h4>
        <strong><small>Occupation:</small></strong> Criminal: bandit/brigand/thug
        <br/><strong><small>Activity:</small></strong> fighting/at war
        <br/><strong><small>Alignment:</small></strong> Chaotic
        <br/>
        <br/><strong><small>Physical Appearance:</small></strong> lasting injury (bad leg, arm, etc.)
        <br/><strong><small>Personality:</small></strong> cruel/belligerent/bully
        <br/><strong><small>Quirk:</small></strong> addict (sweets, drugs, sex, etc.)
        """.trimIndent(),
                getGenerator(PwConstants.NPC, 1).generate(Locale.US))
    }

    @Test
    fun creature() {
        Assert.assertEquals("""
        <h4>Monster</h4>
        plant/fungus
        <br/>
        <br/><strong><small>Activity:</small></strong> laying trap/ambush
        <br/><strong><small>Alignment:</small></strong> Chaotic&nbsp;&nbsp;<strong><small>Size:</small></strong> Tiny
        <br/><strong><small>Disposition:</small></strong> attacking
        <br/><strong><small>No. Appearing:</small></strong> Solitary (1)
        <br/>
        <h5>Optional</h5>
        <em>
        <strong><small>Ability:</small></strong> bless/curse
        <br/><strong><small>Adjective:</small></strong> slick/slimy
        <br/><strong><small>Age:</small></strong> being born/built
        <br/><strong><small>Aspect:</small></strong> power/strength
        <br/><strong><small>Condition:</small></strong> being built/born
        <br/><strong><small>Feature:</small></strong> heavily armored
        <br/><strong><small>Oddity:</small></strong> weird color/smell/sound
        <br/><strong><small>Tag:</small></strong> Amorphous
        </em>
        """.trimIndent(),
                getGenerator(PwConstants.CREATURE_Monster, 0).generate(Locale.US))
    }


    @Test
    fun danger() {
        Assert.assertEquals("""
        <h4>Danger - Unnatural Entity</h4>
        <h5>Undead Entity</h5>
        <p>
        haunt/wisp
        </p>
        <p>
        <strong><small>Ability:</small></strong> bless/curse
        <br/><strong><small>Activity:</small></strong> laying trap/ambush
        <br/><strong><small>Alignment:</small></strong> Chaotic
        <br/><strong><small>Disposition:</small></strong> attacking
        </p>
        """.trimIndent(),
                getGenerator(PwConstants.DANGER, 0).generate(Locale.US))
    }

    @Test
    fun explore_dungeon() {
        Assert.assertEquals("""
        <h3>Explore</h3>
        <h4>Area Type: Common [Unthemed]</h4>
        <h5>Contents:</h5>
        empty
        <h5>Optional</h5>
        <em>
        &nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Adjective:</small></strong> slick/slimy
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Element:</small></strong> air
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Oddity:</small></strong> weird color/smell/sound
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;<strong><small>Orientation:</small></strong> down/earthward
        </em>
        """.trimIndent(),
                getGenerator(PwConstants.EXPLORE_DUNGEON, 0).generate(Locale.US))
    }

    @Test
    fun follower() {
        Assert.assertEquals("""
        <h4>Follower</h4>
        <strong><small>Competence:</small></strong> A liability
        <br/><strong><small>Background:</small></strong> Life of servitude/oppression
        <br/>
        <br/><strong><small>Quality:</small></strong> -1&nbsp;&nbsp;<strong><small>Loyalty:</small></strong> 0&nbsp;&nbsp;<strong><small>Cost:</small></strong> Debauchery
        <br/>
        <br/><strong><small>Instinct:</small></strong> Loot, pillage, and burn
        <br/>
        <br/><strong><small>Hit Points:</small></strong> 3HP (weak/frail/soft)
        <br/><strong><small>Damage Die:</small></strong> d4 (Not very dangerous)
        <br/>
        <br/><strong><small>Physical Appearance:</small></strong> disfigured (missing teeth, eye, etc.)
        <br/><strong><small>Personality:</small></strong> loner/alienated/antisocial
        <br/><strong><small>Quirk:</small></strong> insecure/racist/xenophobic

        <h5>Tags</h5>
        ?-Wise<br/>Meek<br/>
        """.trimIndent(),
                getGenerator(PwConstants.FOLLOWER, 0).generate(Locale.US))
    }
}
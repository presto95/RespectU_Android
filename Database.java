package com.respect.presto.respectu;

import android.content.Context;
import android.content.SharedPreferences;

import java.net.ContentHandler;
import java.util.Arrays;
import java.util.Locale;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmResults;
import io.realm.RealmSchema;

/**
 * Created by presto on 2017. 10. 13..
 */

public class Database {

    Database(Context context, int version, String locale){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(SongInfo.class).findAll().deleteAllFromRealm();
                realm.where(MissionInfo.class).findAll().deleteAllFromRealm();
                realm.where(TrophyInfo.class).findAll().deleteAllFromRealm();
                realm.where(AchievementInfo.class).findAll().deleteAllFromRealm();
            }
        });


        addSong("Technika1", "Access", "Sphazer", "135", 2, 4, 7, 3, 6, 0, 3, 0, 12, 5, 7, 12);
        addSong("Technika1", "Area 7", "Sphazer", "130", 4, 0, 10, 4, 7, 10, 5, 7, 11, 4, 7, 12);
        addSong("Technika1", "Beyond the Future", "7  Sequence", "150", 4, 8, 11, 4, 8, 11, 4, 9, 12, 4, 9, 12);
        addSong("Technika1", "Dear my Lady", "Oriental ST8", "128", 5, 9, 0, 5, 7, 10, 5, 7, 10, 4, 7, 10);
        addSong("Technika1", "DJMAX", "Humming Urban Stereo", "128", 2, 7, 0, 3, 0, 8, 4, 8, 0, 4, 8, 0);
        addSong("Technika1", "Fury", "Sugardonut", "135", 4, 9, 11, 5, 8, 12, 5, 9, 12, 5, 10, 12);
        addSong("Technika1", "HEXAD", "Electronic Boutique", "135", 5, 10, 13, 5, 9, 12, 5, 9, 12, 6, 10, 13);
        addSong("Technika1", "Honeymoon", "Humming Urban Stereo", "150", 3, 5, 8, 4, 0, 8, 4, 8, 0, 3, 9, 0);
        addSong("Technika1", "I want You", "Lin-G", "140", 3, 6, 8, 3, 8, 10, 5, 8, 11, 4, 9, 11);
        addSong("Technika1", "Landscape", "Tsukasa", "140", 6, 9, 0, 6, 8, 11, 5, 9, 12, 7, 9, 13);
        addSong("Technika1", "Melody", "bermei.inazawa", "188", 5, 8, 11, 5, 8, 11, 4, 8, 12, 5, 10, 12);
        addSong("Technika1", "Play the Future", "Urbatronic Chopsticks", "128", 4, 9, 0, 4, 7, 10, 6, 10, 0, 5, 0, 10);
        addSong("Technika1", "Remember", "Lin-G", "150", 3, 8, 10, 4, 7, 10, 4, 7, 11, 5, 0, 11);
        addSong("Technika1", "Shoreline", "Oriental ST8", "135", 4, 8, 10, 6, 11, 0, 6, 11, 0, 6, 8, 12);
        addSong("Technika1", "SON OF SUN", "Hosoe Shinji", "200", 7, 9, 13, 7, 10, 14, 7, 11, 15, 7, 10, 15);
        addSong("Technika1", "SuperSonic", "Planetboom", "156", 4, 7, 11, 5, 8, 12, 6, 9, 12, 6, 10, 13);
        addSong("Technika1", "Sweet Shining Shooting Star", "Croove", "140", 3, 8, 10, 3, 6, 10, 6, 0, 10, 6, 0, 11);
        addSong("Technika1", "The Last Dance", "Urbatronic Chopsticks", "102", 4, 0, 8, 5, 11, 0, 5, 10, 0, 4, 0, 12);
        addSong("Technika1", "Thor", "XeoN", "147", 7, 11, 14, 6, 10, 14, 6, 11, 14, 7, 11, 14);
        addSong("Technika1", "Voyage", "makou", "125", 6, 9, 0, 5, 10, 0, 3, 9, 11, 5, 11, 0);

        addSong("CE", context.getString(R.string.Proposed_Flower_Wolf), "ReX", "80", 1,3,6,1,6,0,1,4,7,1,3,7);
        addSong("CE", context.getString(R.string.Come_to_Me), "CLAZZIQUAI", "125", 3,5,8,4,0,8,2,7,9,4,8,12);
        addSong("CE", context.getString(R.string.To_You), "Sweetune", "133", 3,6,0,2,0,8,2,5,8,2,7,0);
        addSong("CE", context.getString(R.string.Forever), "BEXTER", "114", 4,6,8,4,0,8,3,6,9,2,6,9);
        addSong("CE", "Closer", "3rd Coast", "120", 3,0,8,3,8,0,3,6,0,4,8,0);
        addSong("CE", "Coastal Tempo", "3rd Coast", "135", 5,7,11,3,8,12,4,7,11,4,8,11);
        addSong("CE", "Color", "CLAZZIQUAI", "120", 5,0,11,5,10,0,7,0,11,5,9,12);
        addSong("CE", "Creator", "CLAZZIQUAI", "117", 2,7,13,1,5,11,5,9,0,1,10,0);
        addSong("CE", "Electronics", "CLAZZIQUAI", "128", 4,8,11,4,8,13,5,8,12,4,9,13);
        addSong("CE", "Fate", "STi", "110", 3,7,9,3,8,10,3,9,0,3,7,10);
        addSong("CE", "First Kiss", "BJJ", "107", 2,4,8,2,4,7,2,5,7,2,4,8);
        addSong("CE", "Flea", "CLAZZIQUAI", "126", 4,9,12,4,9,12,5,9,12,6,0,13);
        addSong("CE", "Freedom", "CLAZZIQUAI", "126", 5,7,10,5,7,10,7,0,11,6,8,12);
        addSong("CE", "Here in the Moment", "Ruby Tuesday", "115", 4,7,10,4,8,10,6,8,10,5,0,10);
        addSong("CE", "In My Heart", "Tsukasa", "123", 3,7,10,4,7,10,4,8,10,3,7,11);
        addSong("CE", "Love Mode", "CLAZZIQUAI", "120", 3,8,0,2,6,9,4,9,0,2,6,10);
        addSong("CE", "Lover (CE Style)", "ND Lee", "145", 5,8,10,5,9,0,5,8,11,4,8,10);
        addSong("CE", "Tell Me", context.getString(R.string.Lee_Geol), "89", 1,6,0,2,5,9,3,6,8,1,8,0);
        addSong("CE", "The Clear Blue Sky", "Tsukasa", "178", 4,8,13,6,8,13,6,9,13,4,9,13);
        addSong("CE", "The Night Stage", "CLAZZIQUAI", "120", 3,6,0,3,7,0,3,8,0,3,7,10);
        addSong("CE", "Urban Night", "hYO", "93", 4,8,0,5,8,0,3,8,0,3,0,8);
        addSong("CE", "Y (CE Style)", "ND Lee", "130", 5,8,11,5,10,0,5,8,11,5,9,13);
        addSong("CE", "DARK ENVY", "Sugardonut", "195", 6, 11, 14, 6, 10, 14, 7, 10, 13, 6, 9, 14);

        //Trilogy
        addSong("Trilogy", context.getString(R.string.Memory_of_Wind), "Forte Escape", "110", 3, 8, 0, 3, 6, 0, 3, 7, 0, 4, 9, 0);
        addSong("Trilogy", "A Lie ~Deep Inside Mix~", "Electronic Boutique", "110", 4, 9, 0, 6, 0, 11, 4, 11, 0, 6, 10, 0);
        addSong("Trilogy", "Bye Bye Love ~Nu Jazz Mix~", "Electronic Boutique", "130", 5, 8, 11, 6, 10, 0, 6, 8, 11, 6, 9, 11);
        addSong("Trilogy", "Catch You", "Forte Escape", "180", 3, 8, 0, 6, 8, 10, 4, 8, 0, 6, 8, 11);
        addSong("Trilogy", "For Seasons ~Air Guitar Mix~", "Planetboom", "116", 3, 10, 0, 5, 7, 10, 5, 0, 10, 5, 10, 0);
        addSong("Trilogy", "GET OUT ~Hip Noodle Mix~", "DJ EON", "123", 6, 10, 0, 5, 8, 12, 6, 9, 0, 5, 9, 12);
        addSong("Trilogy", "Mind Control", "NieN", "185", 8, 10, 13, 9, 11, 0, 9, 12, 14, 9, 11, 14);
        addSong("Trilogy", "My Jealousy", "3rd Coast", "130", 4, 7, 10, 6, 8, 0, 6, 8, 12, 6, 8, 11);
        addSong("Trilogy", "NB Girls", "NieN", "162", 6, 9, 0, 7, 0, 12, 5, 9, 11, 7, 12, 0);
        addSong("Trilogy", "sO mUCH iN LUV ~Melodic Twisted Mix~", "Forte Escape", "122", 5, 8, 0, 5, 8, 0, 4, 7, 10, 6, 8, 10);
        addSong("Trilogy", "Someday", "NieN", "136", 3, 5, 9, 4, 8, 10, 5, 7, 11, 4, 6, 10);
        addSong("Trilogy", "STOP", "3rd Coast", "90 ~ 162", 6, 10, 0, 8, 0, 12, 7, 9, 11, 6, 9, 12);
        addSong("Trilogy", "Streetlight", "Nauts", "115", 2, 7, 0, 3, 6, 0, 5, 9, 0, 4, 8, 0);
        addSong("Trilogy", "Syriana ~Blast Wave Mix~", "DJ EON", "135", 8, 10, 0, 8, 10, 12, 8, 11, 0, 8, 10, 13);
        addSong("Trilogy", "Talk! Talk!", "xxdbxx", "143", 5, 10, 13, 6, 8, 13, 8, 11, 13, 7, 9, 12);
        addSong("Trilogy", "Ventilator", "Cycle75", "145", 9, 11, 15, 9, 11, 14, 9, 12, 14, 9, 11, 14);
        addSong("Trilogy", "The One", "Paul Bazooka", "125", 5, 10, 0, 5, 9, 11, 7, 10, 12, 6, 9, 12);
        addSong("Trilogy", "Yo Creo Que Si ~Live House Version~", "BEXTER", "135", 7, 9, 12, 7, 9, 0, 6, 8, 12, 7, 9, 11);
        addSong("Trilogy", "Your Own Miracle ~Disco House Mix~", "makou", "130", 4, 8, 10, 5, 11, 0, 6, 0, 11, 3, 8, 0);
        addSong("Trilogy", "ZET", "BEXTER", "125", 7, 10, 0, 7, 10, 0, 7, 9, 13, 8, 11, 13);

        //Respect
        addSong("Respect", context.getString(R.string.Soar_Stay_With_Me), "Mycin.T", "142", 4, 7, 0, 6, 10, 0, 6, 10, 11, 7, 11, 0);
        addSong("Respect", "2Nite", "ND Lee", "110", 4, 6, 0, 4, 9, 0, 3, 8, 0, 4, 8, 0);
        addSong("Respect", "Armored Phantom", "ned", "151", 3, 7, 0, 6, 11, 0, 7, 9, 12, 6, 11, 0);
        addSong("Respect", "Beautiful Day", "ND Lee", "83", 3, 6, 8, 4, 8, 0, 2, 8, 0, 4, 8, 0);
        addSong("Respect", "Beyond Yourself", "Mycin.T", "90", 6, 9, 0, 6, 10, 0, 7, 9, 12, 6, 11, 0);
        addSong("Respect", "Binary World", "Tsukasa", "182", 5, 8, 13, 5, 7, 13, 9, 12, 13, 5, 7, 13);
        addSong("Respect", "BlackCat", "BEXTER", "130", 5, 11, 0, 6, 11, 0, 5, 8, 12, 7, 12, 0);
        addSong("Respect", "Bullet, Wanted!", "Mycin.T", "150", 4, 8, 0, 7, 10, 0, 6, 9, 11, 7, 10, 0);
        addSong("Respect", "Child of Night", "GOTH", "130", 6, 8, 0, 7, 9, 12, 7, 10, 12, 7, 9, 12);
        addSong("Respect", "Don't Die", "Paul Bazooka", "175", 5, 9, 13, 7, 10, 14, 8, 11, 14, 7, 10, 14);
        addSong("Respect", "Enter The Universe", "GOTH", "162", 6, 9, 12, 7, 10, 14, 9, 12, 14, 7, 10, 14);
        addSong("Respect", "Far East Princess", "Nauts", "102", 5, 9, 10, 5, 10, 0, 3, 9, 12, 5, 9, 0);
        addSong("Respect", "glory day", "BEXTER / Mycin.T", "162", 8, 10, 0, 7, 10, 0, 6, 11, 0, 7, 10, 0);
        addSong("Respect", "Groovin Up", "Mycin.T", "120", 3, 6, 0, 5, 9, 0, 5, 8, 11, 5, 9, 0);
        addSong("Respect", "Heavenly", "Makou", "125", 5, 7, 0, 4, 8, 0, 5, 9, 12, 4, 9, 0);
        addSong("Respect", "KILLER BEE", "GOTH", "116 ~ 155", 4, 6, 11, 7, 11, 0, 8, 9, 13, 7, 12, 0);
        addSong("Respect", "Kung Brother", "Paul Bazooka", "145", 6, 9, 0, 6, 11, 0, 8, 10, 13, 6, 11, 0);
        addSong("Respect", "Liar", "zts", "140", 6, 9, 0, 8, 12, 0, 8, 10, 13, 8, 13, 0);
        addSong("Respect", "Lift You Up", "Makou", "88", 2, 5, 0, 4, 7, 0, 3, 7, 0, 4, 7, 0);
        addSong("Respect", "Mulch", "Sampling Masters MEGA", "200", 6, 12, 0, 7, 0, 14, 8, 12, 14, 7, 0, 15);
        addSong("Respect", "NB RANGER - Virgin Force", "NieN", "198", 5, 9, 0, 7, 12, 15, 7, 12, 14, 7, 11, 15);
        addSong("Respect", "Only for you", "NieN", "122", 1, 4, 9, 5, 7, 10, 4, 7, 11, 5, 7, 10);
        addSong("Respect", "OPEN FIRE", "JC", "140", 4, 7, 0, 4, 8, 0, 5, 7, 0, 5, 8, 0);
        addSong("Respect", "quixotic", "bermei.inazawa", "174", 7, 12, 0, 7, 11, 0, 6, 0, 13, 7, 11, 0);
        addSong("Respect", "Remains Of Doom", "NieN", "124", 7, 13, 0, 6, 9, 14, 9, 12, 15, 6, 10, 13);
        addSong("Respect", "Royal Clown", "bermei.inazawa", "143 ~ 164", 6, 9, 0, 7, 11, 0, 7, 10, 13, 7, 10, 0);
        addSong("Respect", "Nevermind", "Paul Bazooka", "142", 7, 10, 13, 7, 11, 0, 7, 10, 13, 6, 10, 15);
        addSong("Respect", "Runaway", "LeeZu", "140", 6, 10, 0, 8, 11, 0, 9, 11, 12, 8, 13, 0);
        addSong("Respect", "Running girl", "Mycin.T", "170", 5, 7, 0, 5, 9, 0, 4, 10, 12, 6, 10, 0);
        addSong("Respect", "Ruti'n (GOTH Wild Electro Remix)", "GOTH", "112", 6, 10, 0, 4, 10, 0, 7, 10, 13, 9, 12, 0);
        addSong("Respect", "Secret Dejavu", "DINY", "160", 4, 6, 10, 5, 10, 0, 6, 8, 11, 5, 10, 0);
        addSong("Respect", "Shadow Flower", "ned", "142", 3, 6, 0, 6, 9, 0, 5, 11, 0, 6, 9, 0);
        addSong("Respect", "The Feelings", "Supbaby", "130", 5, 7, 0, 6, 9, 0, 6, 10, 0, 6, 10, 0);
        addSong("Respect", "The Lost Story", "NEOWIZ Bless Soundteam", "70", 1, 4, 0, 4, 8, 0, 2, 7, 0, 4, 7, 0);
        addSong("Respect", "The Obliterator", "GOTH", "186", 5, 8, 0, 7, 11, 0, 8, 0, 13, 7, 11, 0);
        addSong("Respect", "U.A.D", "HAYAKO", "129", 3, 6, 0, 5, 10, 0, 6, 8, 11, 8, 0, 12);
        addSong("Respect", "v o l d e n u i t", "Cuve", "105", 5, 9, 12, 4, 9, 12, 5, 9, 12, 6, 9, 13);
        addSong("Respect", "waiting for me", "Croove", "150", 3, 8, 0, 4, 8, 0, 4, 9, 0, 5, 9, 0);
        addSong("Respect", "Waiting for you", "Mycin.T", "175", 4, 8, 0, 6, 10, 0, 6, 12, 0, 7, 11, 0);
        addSong("Respect", "We're All Gonna Die", "Paul Bazooka", "180", 7, 12, 14, 8, 12, 0, 11, 13, 15, 8, 12, 15);
        addSong("Respect", "WHY", "Nauts", "84", 3, 7, 0, 5, 10, 0, 2, 7, 10, 4, 7, 0);
        addSong("Respect", "Break a Spell", "Daisuke Ishiwatari", "200", 5, 9, 14, 6, 10, 0, 7, 9, 14, 7, 10, 14);
        addSong("Respect", "Holy Orders (Be Just Or Be Dead)", "Daisuke Ishiwatari", "120", 4, 9, 11, 6, 8, 11, 6, 9, 12, 6, 10, 12);
        addSong("Respect", "Marionette", "Daisuke Ishiwatari", "136", 5, 9, 13, 7, 12, 0, 6, 10, 13, 8, 0, 13);
        addSong("Respect", "Rising The Sonic", "Dayz", "137", 4,9,12,5,10,13,5,9,13,5,10,14);
        addSong("Respect", "Do you want it", "House Rulez", "123", 5, 8, 0, 7, 9, 0, 5, 9, 0, 5, 11, 0);
        addSong("Respect", "Only On", "Dok2", "96", 2, 5, 0, 3, 6, 0, 2, 5, 0, 3, 5, 8);

        //Portable 1
        addSong("Portable1", context.getString(R.string.Ask_To_Wind), "Forte Escape", "108", 1, 7, 0, 6, 7, 0, 3, 7, 9, 4, 8, 0);
        addSong("Portable1", context.getString(R.string.Every_Morning), "ND Lee", "150", 3, 8, 0, 8, 9, 0, 6, 9, 0, 8, 10, 0);
        addSong("Portable1", context.getString(R.string.Piano_Concerto_No_1), "Wav Factory", "156", 5, 10, 0, 7, 11, 0, 7, 11, 0, 7, 11, 0);
        addSong("Portable1", "A.I", "Forte Escape", "138", 4, 9, 0, 8, 12, 0, 7, 11, 13, 8, 10, 0);
        addSong("Portable1", "Astro Fight", "Forte Escape", "183", 8, 13, 0, 8, 11, 0, 7, 13, 14, 8, 12, 0);
        addSong("Portable1", "BlythE", "M2U", "180", 6, 9, 14, 6, 11, 0, 8, 11, 13, 7, 0, 14);
        addSong("Portable1", "Bright Dream", "M2U", "130", 2, 4, 0, 5, 8, 0, 4, 7, 10, 6, 9, 0);
        addSong("Portable1", "Can We Talk", "Forte Escape", "125", 1, 7, 0, 7, 9, 13, 5, 8, 11, 8, 9, 12);
        addSong("Portable1", "Catch Me", "Forte Escape", "145", 3, 6, 0, 6, 0, 0, 7, 8, 0, 8, 12, 0);
        addSong("Portable1", "Chrono Breakers", "NieN", "178", 5, 7, 11, 7, 10, 0, 7, 12, 0, 8, 13, 0);
        addSong("Portable1", "CnP", "CrooFE", "127", 3, 8, 12, 4, 9, 12, 4, 9, 12, 5, 10, 12);
        addSong("Portable1", "Elastic STAR", "Forte Escape", "132", 4, 7, 0, 6, 7, 0, 4, 8, 0, 4, 7, 0);
        addSong("Portable1", "End of the Moonlight", "Forte Escape", "155", 3, 7, 10, 5, 9, 0, 5, 9, 12, 7, 11, 0);
        addSong("Portable1", "Enemy Storm", "Croove", "133", 2, 5, 13, 5, 8, 0, 6, 8, 11, 5, 10, 14);
        addSong("Portable1", context.getString(R.string.Eternal_Memory), "M2U", "125", 2, 6, 0, 3, 0, 0, 2, 7, 0, 5, 7, 0);
        addSong("Portable1", "Extreme Z4", "Forte Escape", "160", 3, 7, 0, 4, 8, 0, 7, 9, 0, 8, 12, 0);
        addSong("Portable1", "FEAR", "Supbaby", "182", 4, 9, 0, 5, 9, 12, 6, 12, 0, 8, 11, 13);
        addSong("Portable1", "Fever GJ", "xxdbxx", "98", 3, 7, 0, 3, 6, 0, 3, 7, 11, 7, 0, 0);
        addSong("Portable1", "FTR", "Supbaby", "140", 6, 10, 0, 5, 10, 0, 8, 11, 0, 7, 11, 0);
        addSong("Portable1", "Funky Chups", "Forte Escape", "127", 4, 0, 0, 5, 10, 0, 4, 6, 0, 7, 0, 0);
        addSong("Portable1", "Futurism", "Forte Escape", "142", 4, 8, 0, 7, 9, 0, 6, 8, 11, 8, 10, 0);
        addSong("Portable1", "HAMSIN", "makou", "150", 9, 0, 15, 6, 9, 13, 9, 12, 14, 6, 9, 14);
        addSong("Portable1", "JBG", "Croove", "102", 7, 11, 0, 7, 11, 0, 7, 10, 12, 11, 0, 0);
        addSong("Portable1", "Jupiter Driving", "xxdbxx", "144", 5, 9, 0, 5, 11, 0, 5, 8, 0, 7, 11, 0);
        addSong("Portable1", "KUDA", "Gonzo", "126", 8, 11, 0, 5, 9, 0, 8, 12, 0, 10, 0, 0);
        addSong("Portable1", "Lemonade", "M2U", "195", 8, 0, 0, 6, 13, 0, 7, 10, 0, 8, 12, 0);
        addSong("Portable1", "Let's Go Baby", "3rd Coast", "108", 2, 5, 0, 6, 8, 0, 3, 7, 10, 9, 0, 0);
        addSong("Portable1", "Light House", "xxdbxx", "162", 4, 9, 0, 4, 11, 0, 6, 8, 11, 7, 12, 0);
        addSong("Portable1", "Long Vacation", "ESTi", "138", 4, 8, 0, 3, 6, 0, 5, 9, 0, 7, 0, 0);
        addSong("Portable1", "Luv Flow", "3rd Coast", "115", 1, 5, 0, 3, 6, 0, 1, 5, 0, 6, 8, 0);
        addSong("Portable1", "MASAI", "Croove", "128", 4, 7, 0, 5, 8, 0, 7, 10, 12, 10, 0, 0);
        addSong("Portable1", "Memory of Beach", "M2U", "130", 6, 0, 0, 7, 0, 0, 6, 9, 12, 8, 0, 0);
        addSong("Portable1", "Minimal Life", "Earbreaker", "145", 5, 7, 0, 7, 9, 0, 8, 12, 0, 8, 10, 14);
        addSong("Portable1", "NB RANGER", "M2U", "140", 8, 12, 0, 7, 12, 0, 7, 10, 13, 9, 13, 0);
        addSong("Portable1", "Never Say", "ND Lee", "90", 3, 6, 0, 6, 7, 0, 2, 7, 12, 8, 0, 0);
        addSong("Portable1", "OBLIVION", "ESTi", "141", 3, 6, 11, 7, 0, 11, 3, 8, 11, 6, 11, 0);
        addSong("Portable1", "OBLIVION ~Rockin' Night Style~", "NieN", "141", 3, 8, 12, 4, 10, 12, 7, 9, 13, 6, 11, 12);
        addSong("Portable1", "ON", "ND Lee", "72", 3, 5, 0, 2, 6, 0, 6, 10, 0, 7, 0, 0);
        addSong("Portable1", "One the Love", "xxdbxx", "125", 2, 5, 0, 6, 8, 0, 3, 6, 11, 7, 8, 0);
        addSong("Portable1", "Out Law", "Croove", "126", 5, 12, 0, 7, 12, 0, 7, 11, 13, 8, 12, 0);
        addSong("Portable1", "Para-Q", "Forte Escape", "160", 3, 10, 0, 6, 8, 0, 7, 10, 0, 10, 0, 0);
        addSong("Portable1", "Ray of Illuminati", "ESTi", "150", 4, 7, 13, 6, 8, 13, 7, 10, 13, 8, 11, 0);
        addSong("Portable1", "RED", "Croove", "107", 4, 6, 0, 5, 13, 0, 6, 9, 12, 8, 13, 0);
        addSong("Portable1", "REVENGE", "ND Lee", "120", 5, 0, 10, 3, 7, 0, 8, 12, 0, 10, 0, 0);
        addSong("Portable1", "Road Of Death", "NieN", "180", 4, 9, 0, 7, 13, 0, 8, 11, 14, 7, 13, 0);
        addSong("Portable1", "Rock Or Die", "NieN", "106", 6, 0, 0, 6, 9, 0, 6, 10, 12, 6, 9, 0);
        addSong("Portable1", "Save My Dream", "Forte Escape", "125", 1, 4, 0, 2, 4, 0, 2, 5, 9, 5, 8, 0);
        addSong("Portable1", "SIN", "ESTi", "190", 3, 6, 11, 7, 10, 0, 7, 10, 14, 9, 12, 15);
        addSong("Portable1", "SIN ~The Last Scene~", "ESTi", "200", 7, 12, 14, 7, 11, 0, 8, 12, 14, 8, 13, 0);
        addSong("Portable1", "Sunny Side", "Croove", "112", 4, 8, 0, 5, 9, 0, 5, 8, 11, 10, 0, 0);
        addSong("Portable1", "Sunny Side ~Deepn' Soul Mix~", "makou", "122", 7, 10, 0, 7, 0, 0, 7, 0, 11, 8, 10, 0);
        addSong("Portable1", "Temptation", "S-TRO", "136", 4, 10, 0, 4, 10, 0, 6, 0, 12, 9, 0, 0);
        addSong("Portable1", "Triple Zoe", "Forte Escape", "150", 4, 11, 0, 6, 11, 0, 8, 12, 0, 10, 12, 0);
        addSong("Portable1", "Ya! Party!", "Forte Escape", "194", 4, 8, 0, 5, 10, 0, 5, 8, 12, 9, 0, 0);
        addSong("Portable1", "Dreadnought", "EarBreaker", "140", 6,9,12,8,11,0,8,0,13,8,13,0);

        //Portable 2
        addSong("Portable2", context.getString(R.string.HeartBeat), "ND Lee", "155", 3, 5, 0, 4, 8, 0, 4, 7, 9, 6, 9, 0);
        addSong("Portable2", context.getString(R.string.Taekwonburi), "xxdbxx", "162", 5, 7, 0, 6, 0, 11, 6, 10, 14, 7, 0, 12);
        addSong("Portable2", "A Lie", "makou", "100", 2, 5, 0, 5, 9, 0, 4, 6, 12, 7, 9, 0);
        addSong("Portable2", "Another DAY", "Forte Escape", "142", 3, 7, 11, 6, 8, 0, 5, 8, 10, 7, 9, 0);
        addSong("Portable2", "Brain Storm", "Croove", "172", 6, 9, 0, 7, 11, 14, 9, 13, 0, 8, 12, 14);
        addSong("Portable2", "Brandnew Days", "Planetboom", "124", 3, 8, 0, 6, 8, 0, 7, 10, 11, 7, 10, 0);
        addSong("Portable2", "Brave it Out", "BEXTER", "124", 6, 8, 0, 5, 9, 11, 6, 10, 13, 7, 10, 12);
        addSong("Portable2", "Bye Bye Love", "3rd Coast", "120", 2, 8, 0, 6, 7, 0, 6, 9, 11, 6, 8, 0);
        addSong("Portable2", "Chain of Gravity", "Tsukasa", "155", 5, 11, 0, 5, 10, 0, 7, 10, 12, 6, 11, 0);
        addSong("Portable2", "Cherokee", "xxdbxx", "136", 5, 8, 0, 7, 9, 0, 6, 9, 13, 7, 10, 0);
        addSong("Portable2", "DIVINE SERVICE", "Electronic Boutique", "151", 4, 7, 0, 4, 9, 0, 4, 8, 12, 7, 10, 0);
        addSong("Portable2", "Dream of You", "makou", "192", 4, 6, 11, 6, 10, 0, 5, 9, 11, 8, 11, 0);
        addSong("Portable2", "Fallen Angel", "DJ Mocha", "142", 4, 8, 0, 4, 8, 0, 3, 7, 10, 8, 10, 0);
        addSong("Portable2", "Fentanest", "Earbreaker / Eszett", "20 ~ 160", 4, 10, 0, 6, 9, 0, 7, 11, 0, 6, 9, 0);
        addSong("Portable2", "For Seasons", "makou", "116", 1, 6, 0, 6, 9, 0, 4, 7, 11, 5, 9, 0);
        addSong("Portable2", "For the IKARUS", "NieN", "154", 4, 8, 0, 5, 11, 0, 8, 0, 12, 6, 12, 0);
        addSong("Portable2", "Get on Top", "Planetboom", "125", 3, 7, 0, 6, 9, 0, 5, 8, 12, 7, 10, 0);
        addSong("Portable2", "GET OUT", "ND Lee", "112", 5, 8, 0, 4, 9, 0, 4, 8, 13, 7, 10, 0);
        addSong("Portable2", "Good Bye", "Ruby Tuesday", "136", 5, 7, 0, 4, 9, 0, 7, 0, 12, 6, 9, 0);
        addSong("Portable2", "Hello Pinky", "NieN", "141", 5, 8, 0, 5, 10, 0, 7, 11, 0, 6, 11, 0);
        addSong("Portable2", "Higher", "Supbaby", "137", 4, 8, 0, 6, 11, 0, 6, 9, 0, 4, 8, 12);
        addSong("Portable2", "Ladymade Star", "ESTi", "136", 2, 6, 0, 3, 8, 0, 5, 8, 10, 5, 8, 0);
        addSong("Portable2", "Lost n' found", "bermei.inazawa", "165", 3, 7, 0, 6, 8, 0, 5, 9, 0, 7, 9, 0);
        addSong("Portable2", "Memoirs", "M2U", "140", 4, 9, 0, 7, 10, 0, 6, 9, 11, 7, 10, 0);
        addSong("Portable2", "Mess it Up", "Nauts", "140", 5, 9, 0, 4, 9, 0, 9, 12, 0, 6, 10, 0);
        addSong("Portable2", "Midnight Blood", "NieN", "147", 6, 13, 0, 6, 13, 0, 7, 10, 13, 6, 9, 13);
        addSong("Portable2", "Miles", "Electronic Boutique", "130", 2, 10, 0, 5, 10, 13, 4, 9, 13, 4, 11, 13);
        addSong("Portable2", "Minus 3", "Croove", "147", 8, 11, 0, 6, 12, 0, 10, 0, 13, 7, 12, 0);
        addSong("Portable2", "My Alias", "Dayz", "110", 6, 9, 0, 6, 9, 12, 6, 9, 14, 5, 10, 0);
        addSong("Portable2", "NANO RISK", "Dayz", "176", 6, 0, 0, 7, 11, 0, 6, 9, 12, 7, 11, 0);
        addSong("Portable2", "NB POWER", "NieN", "185", 5, 7, 0, 6, 9, 13, 7, 11, 13, 7, 10, 0);
        addSong("Portable2", "NB Rangers -Returns-", "NieN", "145", 5, 9, 0, 7, 11, 0, 9, 11, 13, 7, 12, 0);
        addSong("Portable2", "Negative Nature", "Electronic Boutique", "125 ~ 145", 4, 8, 0, 4, 7, 0, 7, 12, 0, 4, 8, 0);
        addSong("Portable2", "Nightmare", "M2U", "190", 10, 12, 0, 8, 13, 15, 8, 13, 15, 8, 12, 15);
        addSong("Portable2", "Phantom Of Sky", "M2U", "115", 3, 7, 10, 4, 7, 0, 5, 10, 0, 4, 8, 0);
        addSong("Portable2", "plastic method", "zts", "118", 5, 8, 0, 8, 12, 0, 8, 12, 0, 8, 12, 0);
        addSong("Portable2", "Right Now", "makou", "90", 1, 5, 0, 4, 8, 0, 4, 8, 11, 6, 8, 0);
        addSong("Portable2", "Rocka-a-doodle-doo", "makou", "135", 3, 9, 0, 4, 8, 0, 7, 11, 0, 5, 9, 0);
        addSong("Portable2", "Rolling On the Duck", "NieN", "180", 7, 10, 0, 7, 10, 14, 8, 11, 14, 7, 10, 14);
        addSong("Portable2", "Seeker", "M2U", "150", 5, 9, 0, 8, 0, 14, 5, 9, 13, 7, 13, 0);
        addSong("Portable2", "Showtime", "Ruby Tuesday", "138", 6, 8, 0, 6, 9, 0, 8, 12, 0, 6, 10, 0);
        addSong("Portable2", "Smoky Quartz", "makou", "104", 3, 6, 0, 7, 10, 0, 6, 0, 11, 7, 13, 0);
        addSong("Portable2", "sO mUCH iN LUV", "3rd Coast", "130", 1, 6, 0, 3, 6, 0, 4, 7, 11, 7, 0, 0);
        addSong("Portable2", "SQUEEZE", "Oriental ST8", "147", 4, 9, 0, 7, 10, 0, 8, 10, 12, 7, 10, 0);
        addSong("Portable2", "STALKER", "ND Lee", "112", 5, 10, 0, 7, 9, 0, 6, 10, 12, 8, 0, 14);
        addSong("Portable2", "StarFish", "PlanetBoom", "150", 6, 9, 0, 7, 10, 0, 6, 10, 0, 6, 9, 0);
        addSong("Portable2", "Stay with me", "Ruby Tuesday", "140", 2, 4, 0, 4, 7, 0, 3, 7, 0, 5, 9, 0);
        addSong("Portable2", "Sunset Rider", "Nauts", "170", 5, 9, 0, 6, 10, 0, 5, 7, 11, 6, 9, 0);
        addSong("Portable2", "Syriana", "BEXTER", "135", 6, 9, 0, 6, 9, 0, 6, 9, 13, 5, 9, 0);
        addSong("Portable2", "WhiteBlue", "zts", "144", 7, 9, 13, 6, 10, 13, 7, 11, 13, 8, 11, 13);
        addSong("Portable2", "Yellowberry -AJ Mix-", "Forte Escape", "151", 4, 7, 0, 3, 6, 0, 5, 9, 0, 4, 8, 0);
        addSong("Portable2", "Yo Creo Que Si", "makou", "135", 6, 8, 0, 6, 9, 0, 8, 0, 12, 7, 9, 0);
        addSong("Portable2", "Your Own Miracle", "Ruby Tuesday", "136", 3, 9, 0, 3, 6, 10, 6, 10, 12, 7, 10, 13);

        //MissionInfo - Technika1
        addMission("Technika1", "Platinum Mixing", "Idol Mania", "First Kiss", "NORMAL", "4B", "I want You", "NORMAL", "4B", "Ladymade Star", "HARD", "4B", 800000, 0, 0, 0, 0, "Fever-Manual", "Gallery : I want you (3)");
        addMission("Technika1", "Platinum Mixing", "Metro Drive", "Y (CE Style)", "NORMAL", "6B", "Melody", "NORMAL", "6B", "The Clear Blue Sky", "NORMAL", "6B", 0, 0, 4000, 93, 0, "Fever-Manual", "Plate : Honeymoon");
        addMission("Technika1", "Platinum Mixing", "Using Effect", "Play the Future", "NORMAL", "5B", "Beyond the Future", "NORMAL", "5B", "Do you want it", "NORMAL", "5B", 0, 0, 0, 0, 20, "Fever-OFF, FADER 2", "Plate : Shoreline");
        addMission("Technika1", "Platinum Mixing", "Mr.Perfect", "Remember", "NORMAL", "4B", 0, 0, 0, 100, 0, "Fever-OFF", "Plate : Remember");
        addMission("Technika1", "Platinum Mixing", "High Technician", "CnP", "MAXIMUM", "5B", "Dreadnought", "MAXIMUM", "4B", "SIN", "MAXIMUM", "6B", 990000, 5, 0, 0, 0, "Fever-Manual", "Gallery : EXTRA (9)");
        addMission("Technika1", "Platinum Mixing", "Sound Storm", "Enemy Storm", "MAXIMUM", "4B", "Brain Storm", "MAXIMUM", "5B", "Thor", "MAXIMUM", "6B", 0, 5, 3900, 95, 25, "Fever-Manual", "Gallery : Thor");
        addMission("Technika1", "Technical Mixing", "First Step", "Dear my Lady", "NORMAL", "4B", "Honeymoon", "HARD", "4B", "DJMAX", "HARD", "4B", "??", "SPECIAL", "TB", 900000, 0, 0, 0, 0, "Fever-OFF", "Gallery : Honeymoon (3)");
        addMission("Technika1", "Technical Mixing", "Electro EP", "Access", "HARD", "5B", "Your Own Miracle", "HARD", "5B", "Area 7", "HARD", "5B", "??", "SPECIAL", "TB", 0, 0, 800, 0, 0, "Fever-OFF", "Plate : SuperSonic");
        addMission("Technika1", "Technical Mixing", "Core Sound", "Beyond the Future", "HARD", "6B", "Voyage", "HARD", "6B", "Landscape", "HARD", "6B", "??", "SPECIAL", "TB", 0, 0, 0, 95, 0, "Fever-OFF", "Gallery : Voyage");
        addMission("Technika1", "Technical Mixing", "HeartBeat", "Remember", "MAXIMUM", "5B", "Play the Future", "HARD", "5B", "Melody", "MAXIMUM", "5B", "??", "SPECIAL", "TB", 0, 0, 0, 0, 15, "Fever-OFF", "Plate : Melody");
        addMission("Technika1", "Technical Mixing", "Customizer", "Sweet Shining Shooting Star", "MAXIMUM", "8B", "Fury", "MAXIMUM", "8B", "Y (CE Style)", "MAXIMUM", "8B", "??", "SPECIAL", "TB", 1125000, 0, 1750, 98, 0, "Fever-OFF", "Gallery : EXTRA (10)");
        addMission("Technika1", "Technical Mixing", "Conqueror", "SON OF SUN", "HARD", "4B", "SuperSonic", "MAXIMUM", "5B", "HEXAD", "MAXIMUM", "6B", "!?", "SPECIAL", "TB", 1150000, 0, 1500, 98, 0, "Fever-OFF", "Plate : Thor");

        //MissionInfo - Clazziquai Edition
        addMission("CE", "Electronic City", "Club Tour", "Love Mode", "NORMAL", "4B", context.getString(R.string.Come_to_Me), "NORMAL", "4B", "Freedom", "NORMAL", "4B", 850000,0,0,0,0,"Fever-Manual", "Gallery : Clear (Flea Ver.)");
        addMission("CE", "Electronic City", "Hunter & Hunter", "Cherokee", "NORMAL", "4B", "The Feelings", "NORMAL", "5B", context.getString(R.string.Proposed_Flower_Wolf), "MAXIMUM", "6B", 0,3,0,0,0,"Fever-Manual","Gallery : "+context.getString(R.string.Forever)+" (3)");
        addMission("CE", "Electronic City", "BubiBubi", "The Night Stage", "HARD", "4B", "Color", "MAXIMUM", "4B", "Flea", "FX", "4B", "Electronics", "FX", "4B",0,0,0,0,30,"Fever-OFF","Gallery : Freedom (3)");
        addMission("CE", "Electronic City", "4DmaX", context.getString(R.string.To_You), "NORMAL", "5B", "Fate", "NORMAL", "5B", "Urban Night", "NORMAL", "5B", context.getString(R.string.Forever), "NORMAL", "5B", 0,0,0,95,0,"Fever-OFF","Gallery : Creator (3)");
        addMission("CE", "Electronic City", "Catch Me If You Can", "Mess it Up", "HARD", "5B", "StarFish", "HARD", "6B", "Bullet, Wanted!", "HARD", "4B", "In My Heart", "MAXIMUM", "4B", 1000000,0,3000,0,0,"Fever-Manual / FOG","Gallery : In My Heart (3)");
        addMission("CE", "Electronic City", "CLAZZIQUAI", "Creator", "FX", "4B", context.getString(R.string.Come_to_Me), "FX", "4B", "Flea", "MAXIMUM", "6B", 0,0,0,95,0,"Fever-OFF / Gear : CE","Gallery : EXTRA (8)");
        addMission("CE", "Metropolis", "Heaven's Gate", "Closer", "NORMAL", "4B", "For the IKARUS", "NORMAL", "5B", "The Clear Blue Sky", "NORMAL", "6B", context.getString(R.string.Ask_To_Wind), "NORMAL", "8B", 1000000,0,0,0,0,"Fever-Manual","Gallery : The Clear Blue Sky (3)");
        addMission("CE", "Metropolis","GLASS Field", "sO mUCH iN LUV", "HARD", "4B", "Secret Dejavu", "HARD", "4B", "Creator", "HARD", "4B", 0,3,1500,0,0,"Fever-Manual / FADE IN","Gallery : First Kiss (3)");
        addMission("CE", "Metropolis","Metro Project Vol.1", "Coastal Tempo", "FX", "4B", "Here in the Moment", "FX", "4B", "In My Heart", "FX", "4B", "Rising The Sonic", "FX", "4B", 0,0,0,92,0,"Fever-OFF","Gallery : Here in the Moment (3)");
        addMission("CE", "Metropolis","5inary Box", "RANDOM", "HARD", "4B", "RANDOM", "HARD", "5B", "RANDOM", "MAXIMUM", "6B", "RANDOM", "HARD", "8B", "RANDOM", "FX", "4B",0,0,0,0,25,"Fever-OFF","Gallery : Fate (3)");
        addMission("CE", "Metropolis", "DJMAX TOURNAMENT R3", "Dreadnought", "MAXIMUM", "4B", "Coastal Tempo", "MAXIMUM", "5B", "The Clear Blue Sky", "MAXIMUM", "6B", "Y (CE Style)", "MAXIMUM", "8B",0,0,0,0,0,"Fever-AUTO / vs AI","Plate : Clear (Flea Ver.) / Trophy : DJ Alpha Resigns");
        addMission("CE", "Metropolis","DJMAX TOURNAMENT LIVE", "First Kiss", "MAXIMUM", "6B", "Far East Princess", "MAXIMUM", "6B", context.getString(R.string.Proposed_Flower_Wolf), "MAXIMUM", "6B", "Coastal Tempo","MAXIMUM", "6B", "Lover (CE Style)","MAXIMUM","6B",0,0,0,0,10,"Fever-OFF","Gallery : Fail (Flea Ver.) / Trophy : DJMAX ARTIST TEAM");

        //MissionInfo - Respect
        addMission("Respect","Departure","Restarting Line",context.getString(R.string.Ask_To_Wind),"NORMAL","4B","Only for you","NORMAL","4B",400000,0,0,0,0,"Fever-Manual","Music : Only for you");
        addMission("Respect","Departure","Mighty Fine Morning",context.getString(R.string.Every_Morning),"NORMAL","4B",context.getString(R.string.HeartBeat),"NORMAL","4B",0,0,0,85,0,"Fever OFF","Plate : "+context.getString(R.string.Every_Morning));
        addMission("Respect","Departure","Day Dream",context.getString(R.string.Eternal_Memory),"NORMAL","5B","Long Vacation","NORMAL","5B","Lift You Up","NORMAL","5B",0,0,0,0,15,"Fever OFF","Comment : "+context.getString(R.string.Super_Rookie));
        addMission("Respect","Departure","SweeetCute","Bright Dream","NORMAL","4B","Catch Me","NORMAL","4B","Beautiful Day","NORMAL","4B",0,2,0,0,0,"Fever-Manual","Plate : "+context.getString(R.string.HeartBeat));
        addMission("Respect","Departure","Lovextreme","sO mUCH iN LUV","NORMAL","4B","Let's Go Baby","NORMAL","4B","Secret Dejavu","NORMAL","4B",0,0,300,0,0,"Fever-Manual","Music : Secret Dejavu");
        addMission("Respect","Departure","Angelic Eyes","Luv Flow","NORMAL","5B","Save My Dream","HARD","5B","Far East Princess","NORMAL","5B",750000,0,0,0,0,"Fever-Manual","Plate : Departure");
        addMission("Respect","CLUB Road645","enTRANCE","Jupiter Driving","NORMAL","4B","Futurism","NORMAL","4B","Binary World","NORMAL","4B",0,0,600,0,0,"Fever-Manual","Music : Binray World");
        addMission("Respect","CLUB Road645","Dancing Stage","Ladymade Star","NORMAL","5B","Good Bye","NORMAL","5B","Groovin Up","NORMAL","5B",0,0,0,0,10,"Fever OFF / Gear&Note : Ladymade Star","Comment : "+context.getString(R.string.Entertainer));
        addMission("Respect","CLUB Road645","Show me the MAX","Fever GJ","NORMAL","5B","GET OUT","NORMAL","5B","JBG","NORMAL","5B","OPEN FIRE","NORMAL","5B",0,0,0,90,0,"Fever OFF","Plate : Binray World");
        addMission("Respect","CLUB Road645","Purple Lounge","Mess it Up","NORMAL","4B","Dream of You","NORMAL","4B","RED","NORMAL","4B","The Feelings","NORMAL","4B",1000000,0,0,0,0,"Fever-Manual / FADE OUT","Gallery : The Feelings (2)");
        addMission("Respect","CLUB Road645","Groove Zet Coaster","Extreme Z4","NORMAL","4B","Chain of Gravity","NORMAL","4B","For the IKARUS","NORMAL","4B","v o l d e n u i t","NORMAL","4B",0,0,0,0,15,"Fever OFF / SLIDE UP","Comment : "+context.getString(R.string.I_Hate_Fast_Songs));
        addMission("Respect","CLUB Road645","Live in Summer","Memory of Beach","NORMAL","6B","Yo Creo Que Si","NORMAL","6B","Your Own Miracle","NORMAL","4B","Waiting for you","NORMAL","6B",1100000,3,0,0,0,"Fever-Manual","Plate : CLUB Road645");
        addMission("Respect","MAX Theater","Cosmic Fantasy","End of the Moonlight","NORMAL","5B","One the Love","NORMAL","5B","Ray of Illuminati","NORMAL","5B",context.getString(R.string.Soar_Stay_With_Me),"NORMAL","5B",0,0,0,92,0,"Fever OFF","Music : "+context.getString(R.string.Soar_Stay_With_Me));
        addMission("Respect","MAX Theater","Animal Symphony","For Seasons","HARD","4B","Light House","NORMAL","4B","Showtime","NORMAL","4B",830000,0,0,0,0,"Fever-Manual / Gear&Note : Chicken&Egg","Note : Egg");
        addMission("Respect","MAX Theater","Emotion Pulse","DIVINE SERVICE","NORMAL","6B","Stay with me","HARD","6B","Brandnew Days","NORMAL","6B","waiting for me","HARD","6B",0,0,0,93,0,"Fever OFF","Plate : Brandnew Days");
        addMission("Respect","MAX Theater","The Decisive Moment","MASAI","HARD","4B","OBLIVION","HARD","4B","Minus 3","NORMAL","4B","The Obliterator","HARD","4B",0,0,1200,0,0,"Speed : 1.00 / Fever-Manual / FADE IN","Music : The Obliterator");
        addMission("Respect","MAX Theater","Virtual Reality","Lost n' found","NORMAL","6B","Beyond Yourself","NORMAL","6B","FEAR","NORMAL","6B","U.A.D","NORMAL","6B",0,0,0,0,30,"Fever OFF / CHAOS W","Plate : MAX Theater");
        addMission("Respect","MAX Theater","NB is an Open Door","NB RANGER","NORMAL","5B","NB Rangers -Returns-","NORMAL","5B","NB POWER","HARD","5B","NB RANGER - Virgin Force","NORMAL","5B",0,0,3000,0,0,"Fever-Manual / Gear&Note : NB RANGER","Music : NB RANGER - Virgin Force");
        addMission("Respect","Another WORLD","Girl Crush","StarFish","NORMAL","6B","Out Law","NORMAL","6B","GET OUT","HARD","6B","Runaway","NORMAL","6B",1150000,0,0,0,0,"Fever-Manual","Gallery : Runaway (2)");
        addMission("Respect","Another WORLD","Resurrection","Fallen Angel","HARD","6B","Seeker","HARD","6B","SIN","NORMAL","6B","Don't Die","NORMAL","6B",0,3,0,0,0,"Fever-Manual / Gear&Note : SIN","Comment : "+context.getString(R.string.Night_Owl));
        addMission("Respect","Another WORLD","Deadly Poison","The Feelings","NORMAL","5B", context.getString(R.string.Piano_Concerto_No_1),"NORMAL","5B","Midnight Blood","NORMAL","5B","Funky Chups","NORMAL","5B",1050000,0,0,0,10,"Fever OFF", "Gear : NB Ranger");
        addMission("Respect","Another WORLD","Metal Kombat","plastic method","NORMAL","6B","Rocka-a-doodle-doo","NORMAL","6B","Get on Top","HARD","6B","Armored Phantom","HARD","6B",0,3,0,92,0,"Fever-Manual","Comment : "+context.getString(R.string.Dont_Be_Careless));
        addMission("Respect","Another WORLD","Fairy Tales","Phantom Of Sky","HARD","5B","Memoirs","NORMAL","5B","Sunny Side ~Deepn' Soul Mix~","NORMAL","5B","quixotic","NORMAL","5B",0,0,1000,93,0,"Fever OFF / FOG","Gallery : OPEN FIRE (2)");
        addMission("Respect","Another WORLD","Global Sensation","Triple Zoe","NORMAL","6B","Another DAY","HARD","6B","KUDA","NORMAL","6B","Mulch","NORMAL","6B",1280000,0,0,0,0,"Fever OFF / Gear&Note : Mulch","Plate : Another World");
        addMission("Respect","Back STAGE","Emotional Sense",context.getString(R.string.Every_Morning),"NORMAL","5B","Memory of Beach","NORMAL","5B","Sunny Side","HARD","5B","End of the Moonlight","HARD","5B","SIN","HARD","5B",0,0,0,95,20,"Fever OFF / Gear&Note : Portable 1&Classic","Gear : Portable 1");
        addMission("Respect","Back STAGE","Sound Miracle","Your Own Miracle","NORMAL","8B","Brandnew Days","NORMAL","8B","Ladymade Star","HARD","8B","Syriana","HARD","8B","WhiteBlue","HARD","8B",1400000,3,0,0,0,"Fever-Manual / Gear&Note : Portable 2&Classic","Plate : Portable 2");
        addMission("Respect","Back STAGE","Nauts","WHY","HARD","4B","Far East Princess","HARD","4B","Mess it Up","HARD","4B","Sunset Rider","HARD","4B",0,0,5500,0,0,"Fever-Manual / FADE OUT","Comment : "+context.getString(R.string.Diet_Starts_Tomorrow));
        addMission("Respect","Back STAGE","Makou Syndrome","Lift You Up","HARD","8B","Heavenly","HARD","8B","A Lie","HARD","8B","HAMSIN","NORMAL","8B",1270000,0,0,96,0,"Fever-Manual","Gallery : HAMSIN (2)");
        addMission("Respect","Back STAGE","NieNova","Only for you","HARD","6B","Chrono Breakers","NORMAL","6B","For the IKARUS","NORMAL","6B","Remains Of Doom","NORMAL","6B",0,4,7000,0,0,"Fever-Manual / FOG / Gear&Note : Only for you","Plate : Only for you");
        addMission("Respect","Back STAGE","ND Lee","Beautiful Day","HARD","8B","ON","NORMAL","8B","STALKER","NORMAL","8B","2Nite","HARD","8B",0,0,0,0,30,"Fever OFF / BLINK","Plate : Back STAGE");
        addMission("Respect","Chaos Theory","Formula 1","Chain of Gravity","HARD","6B","Jupiter Driving","HARD","6B","Runaway","HARD","6B","Bullet, Wanted!","HARD","6B",1250000,0,0,95,0,"Fever-Manual / SLIDE UP","Comment : "+context.getString(R.string.New_Type));
        addMission("Respect","Chaos Theory","Randomelody","RANDOM","NORMAL","4B","RANDOM","HARD","4B","RANDOM","MAXIMUM","4B",920000,0,0,0,0,"Fever-Manual","Music : BlythE");
        addMission("Respect","Chaos Theory","MAX It Up","RANDOM","NORMAL","5B","RANDOM","HARD","5B","RANDOM","MAXIMUM","5B",0,0,7000,0,0,"Fever-Manual","Comment : "+context.getString(R.string.Versatile));
        addMission("Respect","Chaos Theory","Russian Roulette","RANDOM","NORMAL","6B","RANDOM","HARD","6B","RANDOM","MAXIMUM","6B",0,4,0,97,0,"Fever-Manual","Plate : "+context.getString(R.string.Born_To_Jam));
        addMission("Respect","Chaos Theory","The Genius","RANDOM","NORMAL","8B","RANDOM","HARD","8B","RANDOM","MAXIMUM","8B",0,0,0,0,15,"Fever OFF","Plate : Chaos Theory");
        addMission("Respect","Chaos Theory","Bigbang Theory","NANO RISK","NORMAL","4B","Brain Storm","NORMAL","8B","Para-Q","HARD","5B","Royal Clown","HARD","6B",880000,0,0,0,0,"Fever OFF / CHAOS W","Music : Brain Storm");
        addMission("Respect","Sound Lab","Beat Generation","OBLIVION ~Rockin' Night Style~","HARD","6B","Sunny Side ~Deepn' Soul Mix~","MAXIMUM","6B","Ruti'n (GOTH Wild Electro Remix)","HARD","6B","SIN ~The Last Scene~","HARD","6B",0,5,3000,0,0,"Fever-Manual","Gallery : Lift You Up (3)");
        addMission("Respect","Sound Lab","R.O.D","Rock Or Die","HARD","6B","Road Of Death","HARD","6B","Rolling On the Duck","HARD","8B","Remains Of Doom","HARD","8B",1250000,5,0,0,0,"Fever-Manual","Plate : Remains Of Doom");
        addMission("Respect","Sound Lab","ned","Running girl","HARD","4B","Shadow Flower","HARD","4B","The Obliterator","HARD","4B","Armored Phantom","HARD","4B",0,0,2000,98,0,"Speed : 1.50 / Fever OFF","Note : Don't Die");
        addMission("Respect","Sound Lab","Mycin.Test","Beyond Yourself","HARD","5B","Waiting for you","HARD","5B","Groovin Up","HARD","5B","Bullet, Wanted!","HARD","5B",1300000,4,0,0,0,"Fever-Manual","Plate : Running girl");
        addMission("Respect","Sound Lab","7 SEQUENCE","Extreme Z4","HARD","8B","Catch Me","HARD","8B","Brave it Out","MAXIMUM","8B","Higher","MAXIMUM","8B",0,0,7777,97,0,"Fever-Manual","Comment : "+context.getString(R.string.Guru));
        addMission("Respect","Sound Lab","GOTHic+orpheus","Enter The Universe","HARD","6B","Child of Night","MAXIMUM","6B","Ruti'n (GOTH Wild Electro Remix)","MAXIMUM","6B","The Obliterator","MAXIMUM","6B","KILLER BEE","MAXIMUM","6B",0,0,0,0,30,"Fever OFF / Gear&Note : OBLIVION","Plate : Sound Lab");
        addMission("Respect","Visualizer","TARIta","Lemonade","NORMAL","4B","Hello Pinky","HARD","5B","FTR","NORMAL","8B","Shadow Flower","HARD","6B",0,5,0,98,0,"Fever-Manual","Note : OBLIVION");
        addMission("Respect","Visualizer","ECOmotion","Astro Fight","NORMAL","5B","Kung Brother","HARD","5B",context.getString(R.string.Taekwonburi),"MAXIMUM","5B","Liar","HARD","5B",1350000,0,6000,0,0,"Fever-Manual","Plate : Mulch");
        addMission("Respect","Visualizer","BJ STUDIO","Miles","HARD","4B","2Nite","HARD","5B","Brandnew Days","HARD","6B","WHY","HARD","8B",0,0,3950,0,0,"Fever OFF","Comment : "+context.getString(R.string.Grandpa_Gamer));
        addMission("Respect","Visualizer","Type B.Person","Fentanest","HARD","6B","U.A.D","HARD","5B","Negative Nature","HARD","6B","Royal Clown","HARD","5B",0,0,0,0,5,"Fever OFF","Gallery : EXTRA (4)");
        addMission("Respect","Visualizer","Dumping Life","glory day","HARD","4B","Binary World","HARD","4B","NB RANGER - Virgin Force","HARD","4B","BlackCat","HARD","4B",0,0,8000,98,0,"Fever-Manual","Comment : "+context.getString(R.string.Left_Hand_Only));
        addMission("Respect","Visualizer","Just 100%","RANDOM","NORMAL","4B",0,0,0,100,0,"Fever OFF","Plate : Visualizer");
        addMission("Respect","D-VELOPERS","Light Water","sO mUCH iN LUV","MAXIMUM","6B","Right Now","MAXIMUM","6B","Ya! Party!","MAXIMUM","6B","Running girl","MAXIMUM","6B",1300000,0,0,0,0,"Fever-Manual","Plate : Lift You Up");
        addMission("Respect","D-VELOPERS","juking must die","One the Love","HARD","4B","WhiteBlue","NORMAL","4B",0,0,0,97,1,"Fever OFF / SLIDE DOWN","Comment : 고전게임 매니아");
        addMission("Respect","D-VELOPERS","c12Lover","OBLIVION ~Rockin' Night Style~","HARD","5B","Secret Dejavu","HARD","5B","NB RANGER - Virgin Force","HARD","5B","Rolling On the Duck","HARD","5B",0,0,8500,97,10,"Fever AUTO","Plate : quixotic");
        addMission("Respect","D-VELOPERS","BEXTER","KUDA","HARD","6B","Syriana","HARD","8B","glory day","HARD","6B","BlackCat","MAXIMUM","6B",1350000,0,0,0,5,"Fever-Manual / Gear&Note : glory day","Plate : Syriana");
        addMission("Respect","D-VELOPERS","NKO","Heavenly","HARD","4B","Chrono Breakers","HARD","4B","Ray of Illuminati","HARD","6B","KILLER BEE","HARD","6B",982410,4,2010,90,23,"Fever-Manual","Comment : "+context.getString(R.string.Doting_Father));
        addMission("Respect","D-VELOPERS","SSS","A.I","HARD","4B","Brain Storm","HARD","5B","We're All Gonna Die","HARD","6B","Don't Die","MAXIMUM","8B",0,0,0,0,0,"Fever AUTO / vs AI","Plate : D-VELOPERS / Trophy : DJ Alpha Resigns");
        addMission("Respect","Destination","Bloody MANIcure","Nightmare","HARD","8B","quixotic","MAXIMUM","6B","Midnight Blood","HARD","5B","SIN ~The Last Scene~","HARD","4B",1230000,0,0,0,0,"Fever-Manual / FOG","Music : SIN ~The Last Scene~");
        addMission("Respect","Destination","GIGA BREAK","Miles","MAXIMUM","8B","v o l d e n u i t","MAXIMUM","8B","STALKER","MAXIMUM","8B","Minimal Life","MAXIMUM","8B",0,0,0,0,35,"Fever OFF","Comment : "+context.getString(R.string.Genius));
        addMission("Respect","Destination","MAXimum Impact","RANDOM","MAXIMUM","4B","RANDOM","MAXIMUM","5B","RANDOM","MAXIMUM","6B","RANDOM","MAXIMUM","8B",0,5,9999,0,0,"Fever-Manual","Plate : Nightmare");
        addMission("Respect","Destination","HeLLord","Rock Or Die","MAXIMUM","6B","Don't Die","MAXIMUM","5B","We're All Gonna Die","MAXIMUM","4B",0,5,0,98,0,"Fever-Manual","Comment : "+context.getString(R.string.Super_Master));
        addMission("Respect","Destination","Skyscraper","waiting for me","SPECIAL","XB","Sunny Side","SPECIAL","XB","Out Law","SPECIAL","XB","Minus 3","SPECIAL","XB","Enemy Storm","SPECIAL","XB",1600000,0,4500,96,0,"Fever-Manual","Plate : Destination");
        addMission("Respect","Destination","RESPECT FOR PLAYERS","BlythE","MAXIMUM","4B","Seeker","MAXIMUM","5B","Remains Of Doom","MAXIMUM","6B","HAMSIN","MAXIMUM","8B","Nightmare","MAXIMUM","8B","We're All Gonna Die","SPECIAL","XB",2000000,5,10000,97,50,"Fever-Manual","Plate : BlackCat");

        //MissionInfo - Trilogy
        addMission("Trilogy","T-SIDE","Over Your Dream","Catch You","HARD","4B",context.getString(R.string.Memory_of_Wind),"HARD","4B",500000,0,0,0,0,"Fever-Manual / Gear&Note : Trilogy&Classic","Plate : Catch You");
        addMission("Trilogy","T-SIDE","Missing You","My Jealousy","NORMAL","6B","Streetlight","NORMAL","6B","Someday","HARD","6B",0,0,0,0,10,"Fever OFF","Plate : Someday");
        addMission("Trilogy","T-SIDE","5! Ducks","OBLIVION","NORMAL","5B","Ladymade Star","NORMAL","5B",context.getString(R.string.Taekwonburi),"NORMAL","5B",0,0,500,0,0,"Fever-Manual","Plate : Talk! Talk!");
        addMission("Trilogy","T-SIDE","Electronic License","ZET","NORMAL","4B","Syriana ~Blast Wave Mix~","NORMAL","5B","Nevermind","NORMAL","6B",0,0,0,0,0,"Fever OFF / vs AI prototype","Plate : My Jealousy / Trophy : DJ Alpha Resigns");
        addMission("Trilogy","T-SIDE","Max Boy","Your Own Miracle ~Disco House Mix~","NORMAL","6B","sO mUCH iN LUV ~Melodic Twisted Mix~","NORMAL","5B","A Lie ~Deep Inside Mix~","NORMAL","4B",0,3,0,90,0,"Speed : 1.50 / Fever-Manual","Plate : Streetlight");
        addMission("Trilogy","T-SIDE","DJMAX RESPECT U","Only for you","MAXIMUM","4B","Someday","MAXIMUM","4B","Waiting for you","HARD","4B","Running girl","HARD","4B","KILLER BEE","MAXIMUM","4B",0,0,0,0,30,"Fever OFF / Gear&Note : glory day","Gallery : DJMAX RESPECT U / Trophy : 다음 이벤트도 기대해주세요");
        addMission("Trilogy","R-SIDE","2nd Impression","GET OUT ~Hip Noodle Mix~","HARD","4B","For Seasons ~Air Guitar Mix~","MAXIMUM","6B","STOP","HARD","4B","NB Girls","HARD","6B",0,0,0,95,0,"Fever OFF / FADE OUT","");
        addMission("Trilogy","R-SIDE","Beat Phobia","The One","HARD","5B","Yo Creo Que Si ~Live House Version~","HARD","5B","Nevermind","HARD","5B","ZET","HARD","5B",0,4,0,85,0,"Fever-Manual / FOG","Plate : ZET");
        addMission("Trilogy","R-SIDE","Critical Period","RANDOM","HARD","4B","RANDOM","HARD","5B","RANDOM","HARD","6B","RANDOM","HARD","8B",0,0,0,0,25,"Fever OFF","Plate : STOP");
        addMission("Trilogy","R-SIDE","Under Control","Talk! Talk!","HARD","6B","My Alias","HARD","6B","Ventilator","HARD","6B","Mind Control","HARD","6B",1150000,5,0,0,0,"Fever-Manual","");
        addMission("Trilogy","R-SIDE","Boss Match","SIN ~The Last Scene~","MAXIMUM","4B","HAMSIN","MAXIMUM","5B","Seeker","MAXIMUM","6B","Don't Die","MAXIMUM","8B",1353924,0,0,93,13,"Fever AUTO","Gallery : DJMAX RESPECT U (2)");
        addMission("Trilogy","R-SIDE","In My Dream","CnP","HARD","4B","Sunset Rider","HARD","5B","glory day","HARD","6B",0,5,0,97,0,"Fever-Manual","Plate : "+context.getString(R.string.Memory_of_Wind));

        //TrophyInfo - Respect
        addTrophy("Respect","RESPECT You","모든 트로피를 획득했다.","RESPECT You","Collected all DJMAX RESPECT Trophies.","PLATINUM");
        addTrophy("Respect","디맥 그랜드 마스터","레벨 99를 달성했다.","DJMAX GRAND MASTER","You have reached Level 99.","GOLD");
        addTrophy("Respect","비트 마에스트로","미션 50개를 클리어했다.","BEAT MAESTRO","Cleared 50 missions.","GOLD");
        addTrophy("Respect","한계 돌파","500개의 패턴을 MAX COMBO로 클리어했다.","Break the Limit","Cleared 500 patterns in MAX COMBO.","GOLD");
        addTrophy("Respect","완벽 그 자체","누적 점수가 300,000,000점을 돌파했다.","Perfect Perfectionist","Accumulated 300,000,000 points.","GOLD");
        addTrophy("Respect","절반의 성공","레벨 50을 달성했다.","Half Empty? Half Full!","You have reached Level 50","SILVER");
        addTrophy("Respect","프로다운 실력","미션 30개를 클리어했다.","You Must Be a Pro","Cleared 30 missions.","SILVER");
        addTrophy("Respect","열심히 해야지 방법이 없습니다","누적 점수가 200,000,000점을 돌파했다.","Diligence Will Pay Off One Day","Accumulated 200,000,000 points.","SILVER");
        addTrophy("Respect","S랭크 마스터","S랭크로 50회 클리어했다.","S Rank Master","Acquired S Rank for 50 times.","SILVER");
        addTrophy("Respect","콤보를 위해 판정은 포기!","300개의 패턴을 MAX COMBO로 클리어했다.","Combos First!","Cleared 300 patterns in MAX COMBO.","SILVER");
        addTrophy("Respect","THE LORD OF COMBO","999999 콤보를 달성했다.","THE LORD OF COMBO","Accomplished 999999 combos.","SILVER");
        addTrophy("Respect","JUST 100%","RESPECT 곡을 PERFECT로 클리어했다.","JUST 100%","Cleared a pattern from RESPECT category with PERFECT.","SILVER");
        addTrophy("Respect","아 너무 무섭다","5000 콤보 이상으로 클리어했다.","Jaw Dropping Performance","Cleared with 5000 or more combos.","SILVER");
        addTrophy("Respect","이 게임은 내가 지배한다","모든 곡을 클리어했다.","I Will Rule This Game","Cleared all songs.","SILVER");
        addTrophy("Respect","ARCADE KID","ARCADE 모드를 4버튼으로 클리어했다.","ARCADE KID","Cleared ARCADE Mode with 4 Buttons.","BRONZE");
        addTrophy("Respect","The 5th Wave","ARCADE 모드를 5버튼으로 클리어했다.","The 5th Wave","Cleared ARCADE Mode with 5 Buttons.","BRONZE");
        addTrophy("Respect","Awesome MIX!","ARCADE 모드를 6버튼으로 클리어했다.","Awesome MIX!","Cleared ARCADE Mode with 6 Buttons.","BRONZE");
        addTrophy("Respect","Try your ability. Do it!!","ARCADE 모드를 8버튼으로 클리어했다.","Try your ability. Do it!!","Cleared ARCADE Mode with 8 Buttons.","BRONZE");
        addTrophy("Respect","대신귀여운트로피를드리겠습니다","처음으로 클리어에 실패했다.","Hopefully This Trophy Will Help You Keep Calm","Failed a stage for the first time.","BRONZE");
        addTrophy("Respect","나만 운없어..","BREAK 1개로 클리어했다.","Maybe Next Time..","Cleared with a single BREAK.","BRONZE");
        addTrophy("Respect","슈퍼 루키","레벨 10을 달성했다.","Super Rookie","You have reached Level 10.","BRONZE");
        addTrophy("Respect","순탄한 여행","미션 10개를 클리어했다.","A Smooth Ride","Cleared 10 missions.","BRONZE");
        addTrophy("Respect","숨겨왔던 재능","100개의 패턴을 MAX COMBO로 클리어했다.","Hidden Talent","Cleared 100 patterns in MAX COMBO.","BRONZE");
        addTrophy("Respect","점수를 모아야 이득인 부분","누적 점수가 100,000,000점을 돌파했다.","Each Single Point Counts","Accumulated 100,000,000 points.","BRONZE");
        addTrophy("Respect","하고싶은거 다 해","A랭크로 100회 클리어했다.","YOLO","Acquired A Rank for 100 times.","BRONZE");
        addTrophy("Respect","콤보 마이스터","100000 콤보를 달성했다.","Combo Meister","Accomplished 100000 combos.","BRONZE");
        addTrophy("Respect","럭키 해피 데이","정확하게 777 콤보로 클리어했다.","Happy Lucky Day","Cleared with 777 combos.","BRONZE");
        addTrophy("Respect","바람에게 부탁해","ARCADE 모드에서 DMP1 곡으로만 클리어했다.","Ask To Wind","Cleared only with \"Portable 1\" songs in ARCADE Mode.","BRONZE");
        addTrophy("Respect","Your Own Miracle","ARCADE 모드에서 DMP2 곡으로만 클리어했다.","Your Own Miracle","Cleared only with \"Portable 2\" songs in ARCADE Mode.","BRONZE");
        addTrophy("Respect","플레이트 콜렉터","플레이트를 30개 획득했다.","Plate Collector","Acquired 30 plates","BRONZE");
        addTrophy("Respect","기어중의 기어","기어를 15개 획득했다.","The Gear of All Gears","Acquired 15 gears.","BRONZE");
        addTrophy("Respect","노트의 형태","노트를 10개 획득했다.","Everything about Notes","Acquired 10 notes","BRONZE");
        addTrophy("Respect","마이 리틀 갤러리","이미지를 100장 획득했다.","My Little Gallery","Acquired 100 images","BRONZE");
        addTrophy("Respect","아무 말 대잔치","코멘트를 50개 획득했다.","Slang Festival","Acquired 50 comments.","BRONZE");
        addTrophy("Respect","실력 검증","난이도 10 이상의 패턴 30개를 MAX COMBO로 클리어했다.","Testing Your Skills","Cleared 30 patterns with difficulty level 10 or higher in MAX COMBO.","BRONZE");
        addTrophy("Respect","푹 빠졌구나","4버튼 마스터 스코어의 달성률이 70%에 도달했다.","You're So Into This","Accomplished 70% success rate of 4 Button Master Score.","BRONZE");
        addTrophy("Respect","고고학자","처음으로 숨겨진 BGA를 발견했다.","Archeologist","Found a hidden BGA for the first time.","BRONZE");
        addTrophy("Respect","내 마음속에 저장","모든 숨겨진 BGA를 발견했다.","Saved in My Heart","Found all the hidden BGA.","BRONZE");
        addTrophy("Respect","DJ Alpha Resigns","미션에서 A.I를 상대로 승리했다.","DJ Alpha Resigns","Beat the mission against A.I.","BRONZE");
        addTrophy("Respect","엔비레인저가 되고싶어","콜렉션에서 NB RANGER 시리즈의 모든 뮤직 비디오를 감상했다.","Become an NB RANGER","Watched all NB RANGER videos in Collection.","BRONZE");
        addTrophy("Respect","지기 싫다고 생각하고 있어","온라인 매치를 10번 플레이했다.","No One Likes to Lose","Played Online Match 10 times.","BRONZE");
        addTrophy("Respect","언제나 감사합니다","처음으로 CREDIT을 감상했다.","This is for You","Watched CREDITS for the first time.","BRONZE");

        //TrophyInfo - Trilogy
        addTrophy("Trilogy","당신은 대체...","TRILOGY 곡을 모두 S랭크로 클리어했다.","Where Did You Come From...?","Cleared all TRILOGY songs in S Rank.","GOLD");
        addTrophy("Trilogy","제 여자친구가 확실합니다!","\"Someday\"를 MAX COMBO로 클리어했다.","That's Gotta be My Girlfriend!","Cleared \"Someday\" in MAX COMBO.","SILVER");
        addTrophy("Trilogy","트릴로지 메타","ARCADE를 TRILOGY 곡으로만 클리어했다.","TRILOGY Metaplay","Cleared ARCADE Mode playing only TRILOGY songs.","BRONZE");
        addTrophy("Trilogy","뉴 스킨 작렬...!","TRILOGY UI 스킨을 적용했다.","Here Comes a New Skin...!","Used TRILOGY UI Skin.","BRONZE");
        addTrophy("Trilogy","다음 이벤트도 기대해주세요","DJMAX RESPECT U 미션을 클리어했다.","Don't Miss Out On Upcoming Events!","Cleared mission \"DJMAX RESPECT U\".","BRONZE");
        addTrophy("Trilogy","대신푸우른USB를드리겠습니다","10장의 TRILOGY 곡 이미지를 획득했다.","And Now You Deserve This Handmade Trophy!","Acquired 10 TRILOGY Song Images.","BRONZE");
        addTrophy("Trilogy","나올수도 있고 안나올수도 있습니다","TRILOGY 곡 중 숨겨진 BGA를 발견했다.","Pikaboo!","Found a Hidden BGA from a TRILOGY song.","BRONZE");

        //TrophyInfo - Claziquai Edition
        addTrophy("CE", "클리어 위주로 갑시다", "Clazziquai Edition 곡을 모두 S랭크로 클리어했다", "Let ME Be \"Clear\" On These", "Cleared all Clazziquai Edition songs in S Rank.", "GOLD");
        addTrophy("CE", "클럽 투어에 오신것을 환영합니다", "Electronic City를 클리어했다.","Welcome to the CLUB TOUR","Cleared \"Electronic City\".","SILVER");
        addTrophy("CE","이제와서 족자를 다 모을수도 없고","First Kiss 기어의 모든 캐릭터를 보았다.", "Is it too late to start collecting these?","Watched all characters of the Gear : First Kiss.","BRONZE");
        addTrophy("CE","역시 프로 리듬게이머는 달라","Clazziquai Edition 곡으로만 100000 콤보를 달성했다.", "What Makes A Professional Rhythm Gamer","Achieved 100000 Combos with songs only from the Clazziquai Edition.","BRONZE");
        addTrophy("CE", "DJMAX ARTIST TEAM", "DJMAX TOURNAMENT LIVE 미션을 클리어했다.","DJMAX ARTIST TEAM","Cleared mission \"DJMAX TOURNAMENT LIVE\".","BRONZE");
        addTrophy("CE", "METROTRONICS", "ARCADE를 Clazziquai Edition 곡으로만 클리어했다.","METROTRONICS","Cleared Arcade mode playing only Clazziquai Edition Songs.","BRONZE");
        addTrophy("CE", "Go Back From the Top", "Clazziquai Edition 곡 중 숨겨진 BGA를 발견했다.", "Go Back From the Top","Found a Hidden BGA from a Clazziquai Edition Song.","BRONZE");

        //TrophyInfo - Technika1
        addTrophy("Technika1", "플래티넘 크루", "TECHNIKA 곡을 모두 S랭크로 클리어했다.", "PLATINUM CREW", "Cleared all TECHNIKA songs in S rank.", "SILVER");
        addTrophy("Technika1", "Rolling On the Screen", "Technical Mixing에서 할 수 있는 모든 패턴을 플레이했다.", "Rolling On the Screen", "Played all the patterns you can play in \"Technical Mixing\".", "SILVER");
        addTrophy("Technika1", "테크니카의 10번째 생일을 축하해", "숨겨진 패턴을 MAX COMBO로 클리어했다.", "Happy 10th Birthday for TECHNIKA", "Cleared the hidden pattern in MAX COMBO", "SILVER");
        addTrophy("Technika1", "First Step Set 졸업", "First Step 미션에서 플레이 할 수 있는 모든 곡을 클리어했다.", "First Step Set Complete", "Cleared all the songs in the First Step mission.", "BRONZE");
        addTrophy("Technika1", "ONLY FOR ARCADE", "ARCADE를 TECHNIKA 곡으로만 클리어했다.", "ONLY FOR ARCADE", "Cleared ARCADE mode only with TECHNIKA songs.", "BRONZE");
        addTrophy("Technika1", "Stylish eSper Shooting Sports", "COLLECTION 모드에서 SuperSonic의 뮤직 비디오를 감상했다.", "Stylish eSper Shooting Sports", "Watched a SuperSonic video in Collection.", "BRONZE");
        addTrophy("Technika1", "앗 깜짝이야", "Mr.Perfect 미션을 플레이했다.", "What a Surprise", "Played \"Mr.Perfect\" mission.", "BRONZE");
        addTrophy("Technika1", "너희집엔 이런거 없지?", "5가지의 TECHNIKA 전용 플레이트를 획득했다.", "I Bet You Don't Have This at Home", "Acquired 5 TECHNIKA Plates.", "BRONZE");
        addTrophy("Technika1", "댓글댓글단다 댓글댓글단다", "추장의 장비를 갖추고 SON OF SUN을 MAX COMBO로 클리어했다.", "SON OF SUN", "Cleared \"SON OF SUN\" in MAX COMBO with \"SON OF SUN\" GEAR and NOTE Skins.", "BRONZE");
        addTrophy("Technika1", "암튼 레어 카드", "TECHNIKA 곡 중 숨겨진 BGA를 발견했다.", "Rare Card Anyways", "Found a Hidden BGA from a TECHNIKA Song.", "BRONZE");


        //AchievementInfo
        addAchievement(context.getString(R.string.Play_Count), 1, "MUSIC", "Syriana");
        addAchievement(context.getString(R.string.Play_Count), 2, "MUSIC", "OPEN FIRE");
        addAchievement(context.getString(R.string.Play_Count), 3, "MUSIC", "Don't Die");
        addAchievement(context.getString(R.string.Play_Count), 4, "NOTE SKIN", "Mulch");
        addAchievement(context.getString(R.string.Play_Count), 5, "MUSIC", "OBLIVION ~Rockin' Night Style~");
        addAchievement(context.getString(R.string.Play_Count), 6, "COMMENT", context.getString(R.string.GLHF)); //즐겜해요 祝你好運！
        addAchievement(context.getString(R.string.Play_Count), 7, "PLATE", "NB RED");
        addAchievement(context.getString(R.string.Play_Count), 8, "GALLERY", "Binary World (2)");
        addAchievement(context.getString(R.string.Play_Count), 9, "COMMENT", context.getString(R.string.Rhythm_Game_Maniac)); //리듬게임 매니아 音樂游戲愛好者
        addAchievement(context.getString(R.string.Play_Count), 10, "PLATE", "Out Law");
        addAchievement(context.getString(R.string.Player_Level), 1, "MUSIC", "Waiting for you");
        addAchievement(context.getString(R.string.Player_Level), 2, "GEAR SKIN", "Only for you");
        addAchievement(context.getString(R.string.Player_Level), 3, "MUSIC", "NB POWER");
        addAchievement(context.getString(R.string.Player_Level), 4, "MUSIC", "Royal Clown");
        addAchievement(context.getString(R.string.Player_Level), 5, "MUSIC", "BlackCat");
        addAchievement(context.getString(R.string.Player_Level), 6, "GEAR SKIN", "PORTABLE 3");
        addAchievement(context.getString(R.string.Player_Level), 7, "PLATE", "SIN");
        addAchievement(context.getString(R.string.Player_Level), 8, "PLATE", "Seeker");
        addAchievement(context.getString(R.string.Player_Level), 9, "GEAR SKIN", "TECHNIKA 3");
        addAchievement(context.getString(R.string.Player_Level), 10, "PLATE", "HAMSIN");
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 1, "GEAR SKIN", "TECHNIKA 1");
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 2, "MUSIC", "FTR");
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 3, "MUSIC", "Beyond Yourself");
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 4, "GALLERY", "Royal Clown (2)");
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 5, "GALLERY", "Far East Princess (3)");
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 6, "COMMENT", context.getString(R.string.Eager_Beaver)); //들어올 땐 마음대로 已經上癮了吧？
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 7, "PLATE", "Light House");
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 8, "GALLERY", "2NITE (2)");
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 9, "COMMENT", context.getString(R.string.Always_On_Duty));   //평생 현역 終身值班
        addAchievement(context.getString(R.string.ARCADE_Mode_Cleared), 10, "PLATE", "DIVINE SERVICE");
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 1, "MUSIC", "Running girl");
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 2, "MUSIC", "The Feelings");
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 3, "MUSIC", context.getString(R.string.Eternal_Memory));
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 4, "PLATE", "Hello Pinky");
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 5, "COMMENT", context.getString(R.string.Every_Morning));
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 6, "MUSIC", "Sunny Side ~Deepn' Soul Mix~");
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 7, "GALLERY", "One The Love (2)");
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 8, "PLATE", "OBLIVION");
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 9, "GALLERY", "Groovin Up (2)");
        addAchievement(context.getString(R.string.Tunes_Cleared_4B), 10, "COMMENT", context.getString(R.string.Tunes_4B_Love));   //4버튼이 좋아요 贊美4鍵模式
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 1, "MUSIC", "Seeker");
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 2, "GEAR SKIN", "TECHNIKA 2");
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 3, "MUSIC", "JBG");
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 4, "COMMENT", context.getString(R.string.I_Love_Dogs));    //강아지 좋아요! 我愛狗！
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 5, "MUSIC", "Funky Chups");
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 6, "PLATE", "For The IKARUS");
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 7, "GALLERY", "Only for you (2)");
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 8, "PLATE", "CHICKEN");
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 9, "GALLERY", "KILLER BEE (3)");
        addAchievement(context.getString(R.string.Tunes_Cleared_5B), 10, "COMMENT", context.getString(R.string.Tunes_5B_Love)); //5버튼이 좋아요 贊美5鍵模式
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 1, "MUSIC", "A.I");
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 2, "COMMENT", context.getString(R.string.Waiting_for_Weekend));   //주말반 모집 중 注意力不夠
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 3, "MUSIC", "KUDA");
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 4, "MUSIC", "Negative Nature");
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 5, "COMMENT", context.getString(R.string.Stud));  //미소년 美少年
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 6, "MUSIC", "Ya! Party!");
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 7, "PLATE", "TAP SONIC");
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 8, "PLATE", "Sunny Side");
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 9, "GALLERY", "quixotic (3)");
        addAchievement(context.getString(R.string.Tunes_Cleared_6B), 10, "COMMENT", context.getString(R.string.Tunes_6B_Love));    //6버튼이 좋아요 贊美6鍵模式
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 1, "GEAR SKIN", "PORTABLE 2");
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 2, "MUSIC", "Minimal Life");
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 3, "COMMENT", "Mr. Perfect");
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 4, "MUSIC", context.getString(R.string.Piano_Concerto_No_1));
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 5, "COMMENT", context.getString(R.string.NB_Ranger)); //엔비 레인져 NB RANGER
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 6, "MUSIC", "STALKER");
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 7, "GALLERY", "EXTRA (3)");
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 8, "PLATE", context.getString(R.string.Taekwonburi));
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 9, "GALLERY", "The Obliterator (2)");
        addAchievement(context.getString(R.string.Tunes_Cleared_8B), 10, "COMMENT", context.getString(R.string.Tunes_8B_Love));    //8버튼이 좋아요 贊美8鍵模式
        addAchievement(context.getString(R.string.Free_Style_Combo), 1, "MUSIC", "WHY");
        addAchievement(context.getString(R.string.Free_Style_Combo), 2, "GEAR SKIN", "TAP SONIC");
        addAchievement(context.getString(R.string.Free_Style_Combo), 3, "MUSIC", "Mulch");
        addAchievement(context.getString(R.string.Free_Style_Combo), 4, "MUSIC", "Rolling On the Duck");
        addAchievement(context.getString(R.string.Free_Style_Combo), 5, "MUSIC", "Nightmare");
        addAchievement(context.getString(R.string.Free_Style_Combo), 6, "COMMENT", context.getString(R.string.Sheepish));  //굽신굽신 卑躬屈膝
        addAchievement(context.getString(R.string.Free_Style_Combo), 7, "GALLERY", "End of the Moonlight (3)");
        addAchievement(context.getString(R.string.Free_Style_Combo), 8, "COMMENT", context.getString(R.string.Fever_Free_Zone));   //피버 안써욧 FEVER FREE ZONE
        addAchievement(context.getString(R.string.Free_Style_Combo), 9, "GALLERY", "quixotic (7)");
        addAchievement(context.getString(R.string.Free_Style_Combo), 10, "PLATE", "BlythE");
        addAchievement(context.getString(R.string.Mission_Cleared), 1, "PLATE", "NB BLUE");
        addAchievement(context.getString(R.string.Mission_Cleared), 2, "PLATE", "NB GREEN");
        addAchievement(context.getString(R.string.Mission_Cleared), 3, "PLATE", "NB BLACK");
        addAchievement(context.getString(R.string.Mission_Cleared), 4, "PLATE", "NB YELLOW");
        addAchievement(context.getString(R.string.Mission_Cleared), 5, "PLATE", "NB RANGER");
        addAchievement(context.getString(R.string.Mission_Cleared), 6, "GEAR SKIN", "glory day");
        addAchievement(context.getString(R.string.Total_Break), 1, "COMMENT", context.getString(R.string.Cant_Focus));    //집중력 부족 注意力不夠
        addAchievement(context.getString(R.string.Total_Break), 2, "PLATE", "Memoy of Beach");
        addAchievement(context.getString(R.string.Total_Break), 3, "MUSIC", "GET OUT");
        addAchievement(context.getString(R.string.Total_Break), 4, "COMMENT", context.getString(R.string.Lefty));  //왼손잡이 左撇子
        addAchievement(context.getString(R.string.Total_Break), 5, "GEAR SKIN", "Mulch");
        addAchievement(context.getString(R.string.Total_Break), 6, "GALLERY", "Miles (2)");
        addAchievement(context.getString(R.string.Total_Break), 7, "COMMENT", context.getString(R.string.Novice_Here));    //초보입니다 新手來了
        addAchievement(context.getString(R.string.Total_Break), 8, "GALLERY", "NB RANGER (3)");
        addAchievement(context.getString(R.string.Total_Break), 9, "GALLERY", "Brain Storm (2)");
        addAchievement(context.getString(R.string.Total_Break), 10, "COMMENT", context.getString(R.string.High_Class));    //오늘따라 잘 안되네 不可忽視的才能
        addAchievement(context.getString(R.string.Maximum_Max_Combo), 1, "MUSIC", "Far East Princess");
        addAchievement(context.getString(R.string.Maximum_Max_Combo), 2, "GALLERY", "Running girl (2)");
        addAchievement(context.getString(R.string.Maximum_Max_Combo), 3, "PLATE", "Ruti'n (GOTH Wild Electro Remix)");
        addAchievement(context.getString(R.string.Maximum_Max_Combo), 4, "MUSIC", "Chrono Breakers");
        addAchievement(context.getString(R.string.Maximum_Max_Combo), 5, "COMMENT", context.getString(R.string.Hawk_Eye)); //엄청난 동체시력 鷹眼
        addAchievement(context.getString(R.string.Maximum_Max_Combo), 6, "PLATE", "Ladymade Star");
        addAchievement(context.getString(R.string.Maximum_Max_Combo), 7, "GALLERY", "glory day (3)");
        addAchievement(context.getString(R.string.Maximum_Max_Combo), 8, "COMMENT", context.getString(R.string.HAXXOR));   //킹갓엠페러제네럴 超越者
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 1, "MUSIC", "Out Law");
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 2, "NOTE SKIN", "Only for you");
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 3, "MUSIC", "WhiteBlue");
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 4, "GEAR SKIN", "CE");
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 5, "NOTE SKIN", "TECHNIKA 3");
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 6, "GALLERY", "Child of Night (2)");
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 7, "COMMENT", context.getString(R.string.Jack_Of_All_Trades));  //올라운더 靈丹妙藥
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 8, "GALLERY", "Brandnew Days (4)");
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 9, "GALLERY", "We're All Gonna Die (2)");
        addAchievement(context.getString(R.string.Max_Combo_Cleared), 10, "PLATE", "The Obliterator");
        addAchievement(context.getString(R.string.S_Rank_Cleared), 1, "MUSIC", "Midnight Blood");
        addAchievement(context.getString(R.string.S_Rank_Cleared), 2, "COMMENT", context.getString(R.string.Come_At_Me));    //도전하시겠습니까? 想挑戰嗎？
        addAchievement(context.getString(R.string.S_Rank_Cleared), 3, "NOTE SKIN", "TAP SONIC");
        addAchievement(context.getString(R.string.S_Rank_Cleared), 4, "MUSIC", "Road Of Death");
        addAchievement(context.getString(R.string.S_Rank_Cleared), 5, "PLATE", "Good Bye");
        addAchievement(context.getString(R.string.S_Rank_Cleared), 6, "GALLERY", "NB RANGER - Virgin Force (2)");
        addAchievement(context.getString(R.string.S_Rank_Cleared), 7, "GALLERY", "Showtime (2)");
        addAchievement(context.getString(R.string.S_Rank_Cleared), 8, "COMMENT", context.getString(R.string.Unforgettable));   //늘 기억되고 싶은 사람 勿忘我
        addAchievement(context.getString(R.string.S_Rank_Cleared), 9, "COMMENT", context.getString(R.string.Most_Popular));  //인기만점 超級紅人
        addAchievement(context.getString(R.string.S_Rank_Cleared), 10, "PLATE", "Midnight Blood");
        addAchievement(context.getString(R.string.A_Rank_Cleared), 1, "MUSIC", "DIVINE SERVICE");
        addAchievement(context.getString(R.string.A_Rank_Cleared), 2, "MUSIC", "Yo Creo Que Si");
        addAchievement(context.getString(R.string.A_Rank_Cleared), 3, "GALLERY", "Far East Princess (4)");
        addAchievement(context.getString(R.string.A_Rank_Cleared), 4, "COMMENT", context.getString(R.string.I_Love_Cats));    //고양이 좋아요! 我愛貓！
        addAchievement(context.getString(R.string.A_Rank_Cleared), 5, "GALLERY", "Armored Phantom (2)");
        addAchievement(context.getString(R.string.A_Rank_Cleared), 6, "GALLERY", "Bullet, Wanted! (2)");
        addAchievement(context.getString(R.string.A_Rank_Cleared), 7, "GALLERY", "Beyond Yourself (3)");
        addAchievement(context.getString(R.string.A_Rank_Cleared), 8, "COMMENT", context.getString(R.string.Clear_All_Songs));    //목표는 전곡 클리어! 目標是全曲闖闗
        addAchievement(context.getString(R.string.A_Rank_Cleared), 9, "GALLERY", "Sunny Side (2)");
        addAchievement(context.getString(R.string.A_Rank_Cleared), 10, "PLATE", "Memoirs");
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 1, "COMMENT", context.getString(R.string.I_Want_You)); //친추 환영 添加好友大歡迎
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 2, "MUSIC", "Shadow Flower");
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 3, "GEAR SKIN", "CHICKEN");
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 4, "MUSIC", "Showtime");
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 5, "COMMENT", context.getString(R.string.Holy_Land));   //성지순례 聖地巡禮
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 6, "GALLERY", "OBLIVION (2)");
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 7, "MUSIC", "RED");
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 8, "GALLERY", "Runaway (3)");
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 9, "PLATE", "TECHNIKA 2");
        addAchievement(context.getString(R.string.Normal_Difficulty_Mode_Cleared), 10, "COMMENT", context.getString(R.string.Only_Study)); //이젠 정말 공부뿐이야 學習第一！
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 1, "MUSIC", "quixotic");
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 2, "GALLERY", context.getString(R.string.Every_Morning)+" (3)"); //아침형 인간 (3) Every Morning (3)
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 3, "MUSIC", context.getString(R.string.Taekwonburi));
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 4, "MUSIC", "SQUEEZE");
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 5, "COMMENT", context.getString(R.string.Most_Improved)); //일취월장 日新月異
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 6, "MUSIC", "Chain of Gravity");
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 7, "GALLERY", "Secret Dejavu (2)");
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 8, "MUSIC", "Enter The Universe");
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 9, "COMMENT", context.getString(R.string.Sprint));    //전력질주 全力奔跑
        addAchievement(context.getString(R.string.Hard_Difficulty_Mode_Cleared), 10, "PLATE", "PORTABLE 3");
        addAchievement(context.getString(R.string.Maximum_Difficulty_Mode_Cleared), 1, "MUSIC", "Remains Of Doom");
        addAchievement(context.getString(R.string.Maximum_Difficulty_Mode_Cleared), 2, "GALLERY", "U.A.D (2)");
        addAchievement(context.getString(R.string.Maximum_Difficulty_Mode_Cleared), 3, "MUSIC", "HAMSIN");
        addAchievement(context.getString(R.string.Maximum_Difficulty_Mode_Cleared), 4, "GALLERY", "Remains Of Doom (2)");
        addAchievement(context.getString(R.string.Maximum_Difficulty_Mode_Cleared), 5, "COMMENT", context.getString(R.string.Rhythm_Power));   //리듬! 파워! 집중력! 節奏！力量！集中！
        addAchievement(context.getString(R.string.X2_Fever_Activated), 1, "MUSIC", "End of the Moonlight");
        addAchievement(context.getString(R.string.X2_Fever_Activated), 2, "NOTE SKIN", "CAT");
        addAchievement(context.getString(R.string.X2_Fever_Activated), 3, "MUSIC", "Yellowberry -AJ Mix-");
        addAchievement(context.getString(R.string.X2_Fever_Activated), 4, "GALLERY", "Only for you (3)");
        addAchievement(context.getString(R.string.X2_Fever_Activated), 5, "MUSIC", "Mess it Up");
        addAchievement(context.getString(R.string.X2_Fever_Activated), 6, "GEAR SKIN", "SIN");
        addAchievement(context.getString(R.string.X2_Fever_Activated), 7, "GALLERY", "NB RANGER - Virgin Force (3)");
        addAchievement(context.getString(R.string.X2_Fever_Activated), 8, "COMMENT", context.getString(R.string.Shut_In)); //은둔형 외톨이 隱蔽青年
        addAchievement(context.getString(R.string.X2_Fever_Activated), 9, "GALLERY", "Binary World (3)");
        addAchievement(context.getString(R.string.X2_Fever_Activated), 10, "COMMENT", context.getString(R.string.Im_The_Boss));   //대장님 我就是老大
        addAchievement(context.getString(R.string.X3_Fever_Activated), 1, "MUSIC", "Rocka-a-doodle-doo");
        addAchievement(context.getString(R.string.X3_Fever_Activated), 2, "MUSIC", "Bye Bye Love");
        addAchievement(context.getString(R.string.X3_Fever_Activated), 3, "GALLERY", "glory day (4)");
        addAchievement(context.getString(R.string.X3_Fever_Activated), 4, "MUSIC", "ON");
        addAchievement(context.getString(R.string.X3_Fever_Activated), 5, "COMMENT", context.getString(R.string.DMP_Lover));   //포터블 경험자 DMP經曆者
        addAchievement(context.getString(R.string.X3_Fever_Activated), 6, "MUSIC", "Fentanest");
        addAchievement(context.getString(R.string.X3_Fever_Activated), 7, "GALLERY", "Memory of Beach (3)");
        addAchievement(context.getString(R.string.X3_Fever_Activated), 8, "PLATE", "Secret Dejavu");
        addAchievement(context.getString(R.string.X3_Fever_Activated), 9, "GALLERY", "Brandnew Days (3)");
        addAchievement(context.getString(R.string.X3_Fever_Activated), 10, "COMMENT", context.getString(R.string.What_A_Bookworm));    //문과생이 또 文科小子！
        addAchievement(context.getString(R.string.X4_Fever_Activated), 1, "MUSIC", "StarFish");
        addAchievement(context.getString(R.string.X4_Fever_Activated), 2, "MUSIC", "For The IKARUS");
        addAchievement(context.getString(R.string.X4_Fever_Activated), 3, "COMMENT", context.getString(R.string.DMO_Lover));   //온라인 경험자 DMO經曆者
        addAchievement(context.getString(R.string.X4_Fever_Activated), 4, "MUSIC", "Runaway");
        addAchievement(context.getString(R.string.X4_Fever_Activated), 5, "GALLERY", "sO mUCH iN LUV (2)");
        addAchievement(context.getString(R.string.X4_Fever_Activated), 6, "MUSIC", "Dream of You");
        addAchievement(context.getString(R.string.X4_Fever_Activated), 7, "GALLERY", "Chrono Breakers (2)");
        addAchievement(context.getString(R.string.X4_Fever_Activated), 8, "COMMENT", context.getString(R.string.Go_Easy_On_Me));  //제발 살살 좀 請手下留情
        addAchievement(context.getString(R.string.X4_Fever_Activated), 9, "COMMENT", context.getString(R.string.Condition_Disorder));  //컨디션 난조 狀態不佳
        addAchievement(context.getString(R.string.X4_Fever_Activated), 10, "GALLERY", "Enemy Storm (2)");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 1, "MUSIC", "FEAR");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 2, "MUSIC", "Sunset Rider");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 3, "COMMENT", context.getString(R.string.Cute));    //귀여워 可愛
        addAchievement(context.getString(R.string.X5_Fever_Activated), 4, "GALLERY", "Out Law (2)");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 5, "MUSIC", "v o l d e n u i t");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 6, "GALLERY", "BlackCat (2)");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 7, "GALLERY", "Save My Dream (2)");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 8, "MUSIC", "Triple Joe");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 9, "COMMENT", "No Comment");
        addAchievement(context.getString(R.string.X5_Fever_Activated), 10, "PLATE", "Sunset Rider");
        addAchievement(context.getString(R.string.Effector), 1, "MUSIC", "Para-Q");
        addAchievement(context.getString(R.string.Effector), 2, "COMMENT", context.getString(R.string.You_See_That)); //그게 보여요? 那也能看得到嗎？
        addAchievement(context.getString(R.string.Effector), 3, "GALLERY", "Enter The Universe (2)");
        addAchievement(context.getString(R.string.Effector), 4, "MUSIC", "Fever GJ");
        addAchievement(context.getString(R.string.Effector), 5, "GALLERY", "Ruti'n (GOTH Wild Electro Remix) (2)");
        addAchievement(context.getString(R.string.Effector), 6, "COMMENT", context.getString(R.string.Craving_Technika));  //테크니카 하고싶다 TECHNIKA渴望中
        addAchievement(context.getString(R.string.Total_Score), 1, "MUSIC", "KILLER BEE");
        addAchievement(context.getString(R.string.Total_Score), 2, "MUSIC", "Minus 3");
        addAchievement(context.getString(R.string.Total_Score), 3, "COMMENT", context.getString(R.string.Yes_Sir));   //충성충성 絕對忠誠
        addAchievement(context.getString(R.string.Total_Score), 4, "GALLERY", "Don't Die (3)");
        addAchievement(context.getString(R.string.Total_Score), 5, "COMMENT", "!?");
        addAchievement(context.getString(R.string.Total_Score), 6, "NOTE SKIN", "glory day");
        addAchievement(context.getString(R.string.Total_Score), 7, "GALLERY", "Road Of Death (2)");
        addAchievement(context.getString(R.string.Total_Score), 8, "GALLERY", "glory day (2)");
        addAchievement(context.getString(R.string.Total_Score), 9, "GALLERY", "WHY (3)");
        addAchievement(context.getString(R.string.Total_Score), 10, "COMMENT", context.getString(R.string.Hard_Worker));   //노력형 플레이어 努力家
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 1, "MUSIC", "MASAI");
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 2, "COMMENT", context.getString(R.string.Lets_Be_Friends)); //친해지고 싶어요 想親近
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 3, "COMMENT", context.getString(R.string.Lurker));   //온라인 서식중 網絡潛伏者
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 4, "GALLERY", "Heavenly (2)");
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 5, "COMMENT", context.getString(R.string.DJMAX_Missionary)); //디맥 전도사 DJMAX 傳教士
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 6, "GALLERY", "Lift You Up (2)");
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 7, "GALLERY", "Long Vacation (2)");
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 8, "COMMENT", context.getString(R.string.Test_Your_Might));  //누구든지 덤벼 放馬過來吧
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 9, "GALLERY", "Brandnew Days (2)");
        addAchievement(context.getString(R.string.Online_Mode_Playcount), 10, "PLATE", "KILLER BEE");

        RealmResults<SongInfo> songInfo = realm.where(SongInfo.class).findAll().sort("title");
        realm.beginTransaction();
        for (SongInfo i : songInfo){
            i.setLowercase(i.getTitle().toLowerCase());
        }
        if(locale.equals("kor") || locale.equals("ko")){
            int count = 0;
            int size = songInfo.size();
            for(int i=size -  11 ; i < size ; ++i){
                if(count < 10){
                    songInfo.get(i).setLowercase("00"+count);
                }
                else{
                    songInfo.get(i).setLowercase("0"+count);
                }
                ++count;
            }
        }
        realm.commitTransaction();


        //기록되어있는 성과에 따른 스킬 포인트 계산
        //title + key + difficulty + (rank / rate / note / skillpoint)
        SharedPreferences sp = context.getSharedPreferences("Record", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        for (SongInfo i: songInfo){
            String title = i.getTitle();
            float nm4Point = getSkillPoint(i.getNm4(), sp.getString(title+"4BNormalAccuracy", "-"), sp.getString(title+"4BNormalNote", "-"));
            float hd4Point = getSkillPoint(i.getHd4(), sp.getString(title+"4BHardAccuracy", "-"), sp.getString(title+"4BHardNote", "-"));
            float mx4Point = getSkillPoint(i.getMx4(), sp.getString(title+"4BMaximumAccuracy", "-"), sp.getString(title+"4BMaximumNote", "-"));
            float[] max4PointArray = {nm4Point, hd4Point, mx4Point};
            Arrays.sort(max4PointArray);
            float max4Point = max4PointArray[2];
            editor.putFloat(title+"4BSkillPoint", max4Point);
            if(max4Point == nm4Point){
                editor.putString(title+"4BHighestDifficulty", "NORMAL");
                editor.putString(title+"4BHighestRate", sp.getString(title+"4BNormalAccuracy", "-"));
                editor.putString(title+"4BHighestNote", sp.getString(title+"4BNormalNote", "-"));
            }
            else if(max4Point == hd4Point){
                editor.putString(title+"4BHighestDifficulty", "HARD");
                editor.putString(title+"4BHighestRate", sp.getString(title+"4BHardAccuracy", "-"));
                editor.putString(title+"4BHighestNote", sp.getString(title+"4BHardNote", "-"));

            }
            else if(max4Point == mx4Point){
                editor.putString(title+"4BHighestDifficulty", "MAXIMUM");
                editor.putString(title+"4BHighestRate", sp.getString(title+"4BMaximumAccuracy", "-"));
                editor.putString(title+"4BHighestNote", sp.getString(title+"4BMaximumNote", "-"));
            }
            editor.commit();

            float nm5Point = getSkillPoint(i.getNm5(), sp.getString(title+"5BNormalAccuracy", "-"), sp.getString(title+"5BNormalNote", "-"));
            float hd5Point = getSkillPoint(i.getHd5(), sp.getString(title+"5BHardAccuracy", "-"), sp.getString(title+"5BHardNote", "-"));
            float mx5Point = getSkillPoint(i.getMx5(), sp.getString(title+"5BMaximumAccuracy", "-"), sp.getString(title+"5BMaximumNote", "-"));
            float[] max5PointArray = {nm5Point, hd5Point, mx5Point};
            Arrays.sort(max5PointArray);
            float max5Point = max5PointArray[2];
            editor.putFloat(title+"5BSkillPoint", max5Point);
            if(max5Point == nm5Point){
                editor.putString(title+"5BHighestDifficulty", "NORMAL");
                editor.putString(title+"5BHighestRate", sp.getString(title+"5BNormalAccuracy", "-"));
                editor.putString(title+"5BHighestNote", sp.getString(title+"5BNormalNote", "-"));
            }
            else if(max5Point == hd5Point){
                editor.putString(title+"5BHighestDifficulty", "HARD");
                editor.putString(title+"5BHighestRate", sp.getString(title+"5BHardAccuracy", "-"));
                editor.putString(title+"5BHighestNote", sp.getString(title+"5BHardNote", "-"));

            }
            else if(max5Point == mx5Point){
                editor.putString(title+"5BHighestDifficulty", "MAXIMUM");
                editor.putString(title+"5BHighestRate", sp.getString(title+"5BMaximumAccuracy", "-"));
                editor.putString(title+"5BHighestNote", sp.getString(title+"5BMaximumNote", "-"));
            }
            editor.commit();

            float nm6Point = getSkillPoint(i.getNm6(), sp.getString(title+"6BNormalAccuracy", "-"), sp.getString(title+"6BNormalNote", "-"));
            float hd6Point = getSkillPoint(i.getHd6(), sp.getString(title+"6BHardAccuracy", "-"), sp.getString(title+"6BHardNote", "-"));
            float mx6Point = getSkillPoint(i.getMx6(), sp.getString(title+"6BMaximumAccuracy", "-"), sp.getString(title+"6BMaximumNote", "-"));
            float[] max6PointArray = {nm6Point, hd6Point, mx6Point};
            Arrays.sort(max6PointArray);
            float max6Point = max6PointArray[2];
            editor.putFloat(title+"6BSkillPoint", max6Point);
            if(max6Point == nm6Point){
                editor.putString(title+"6BHighestDifficulty", "NORMAL");
                editor.putString(title+"6BHighestRate", sp.getString(title+"6BNormalAccuracy", "-"));
                editor.putString(title+"6BHighestNote", sp.getString(title+"6BNormalNote", "-"));
            }
            else if(max6Point == hd6Point){
                editor.putString(title+"6BHighestDifficulty", "HARD");
                editor.putString(title+"6BHighestRate", sp.getString(title+"6BHardAccuracy", "-"));
                editor.putString(title+"6BHighestNote", sp.getString(title+"6BHardNote", "-"));

            }
            else if(max6Point == mx6Point){
                editor.putString(title+"6BHighestDifficulty", "MAXIMUM");
                editor.putString(title+"6BHighestRate", sp.getString(title+"6BMaximumAccuracy", "-"));
                editor.putString(title+"6BHighestNote", sp.getString(title+"6BMaximumNote", "-"));
            }
            editor.commit();

            float nm8Point = getSkillPoint(i.getNm8(), sp.getString(title+"8BNormalAccuracy", "-"), sp.getString(title+"8BNormalNote", "-"));
            float hd8Point = getSkillPoint(i.getHd8(), sp.getString(title+"8BHardAccuracy", "-"), sp.getString(title+"8BHardNote", "-"));
            float mx8Point = getSkillPoint(i.getMx8(), sp.getString(title+"8BMaximumAccuracy", "-"), sp.getString(title+"8BMaximumNote", "-"));
            float[] max8PointArray = {nm8Point, hd8Point, mx8Point};
            Arrays.sort(max8PointArray);
            float max8Point = max8PointArray[2];
            editor.putFloat(title+"8BSkillPoint", max8Point);
            if(max8Point == nm8Point){
                editor.putString(title+"8BHighestDifficulty", "NORMAL");
                editor.putString(title+"8BHighestRate", sp.getString(title+"8BNormalAccuracy", "-"));
                editor.putString(title+"8BHighestNote", sp.getString(title+"8BNormalNote", "-"));
            }
            else if(max8Point == hd8Point){
                editor.putString(title+"8BHighestDifficulty", "HARD");
                editor.putString(title+"8BHighestRate", sp.getString(title+"8BHardAccuracy", "-"));
                editor.putString(title+"8BHighestNote", sp.getString(title+"8BHardNote", "-"));

            }
            else if(max8Point == mx8Point){
                editor.putString(title+"8BHighestDifficulty", "MAXIMUM");
                editor.putString(title+"8BHighestRate", sp.getString(title+"8BMaximumAccuracy", "-"));
                editor.putString(title+"8BHighestNote", sp.getString(title+"8BMaximumNote", "-"));
            }
            editor.commit();
        }



    }

    void addSong(String series, String title, String composer, String bpm, int nm4, int hd4, int mx4, int nm5, int hd5, int mx5, int nm6, int hd6, int mx6, int nm8, int hd8, int mx8){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        SongInfo song=realm.createObject(SongInfo.class);
        song.setSeries(series);
        song.setTitle(title);
        song.setComposer(composer);
        song.setBpm(bpm);
        song.setNm4(nm4);
        song.setNm5(nm5);
        song.setNm6(nm6);
        song.setNm8(nm8);
        song.setHd4(hd4);
        song.setHd5(hd5);
        song.setHd6(hd6);
        song.setHd8(hd8);
        song.setMx4(mx4);
        song.setMx5(mx5);
        song.setMx6(mx6);
        song.setMx8(mx8);
        realm.commitTransaction();
    }

    void addMission(String type, String section, String title, String song1title, String song1level, String song1key, int scoreLimit, int feverLimit, int comboLimit, int rateLimit, int breakLimit, String more, String reward){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        MissionInfo mission=realm.createObject(MissionInfo.class);
        mission.setType(type);
        mission.setSection(section);
        mission.setTitle(title);
        mission.setSong1title(song1title);
        mission.setSong1level(song1level);
        mission.setSong1key(song1key);
        mission.setScoreLimit(scoreLimit);
        mission.setFeverLimit(feverLimit);
        mission.setComboLimit(comboLimit);
        mission.setRateLimit(rateLimit);
        mission.setBreakLimit(breakLimit);
        mission.setMore(more);
        mission.setReward(reward);
        realm.commitTransaction();
    }

    void addMission(String type, String section, String title, String song1title, String song1level, String song1key, String song2title, String song2level, String song2key, int scoreLimit, int feverLimit, int comboLimit, int rateLimit, int breakLimit, String more, String reward){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        MissionInfo mission=realm.createObject(MissionInfo.class);
        mission.setType(type);
        mission.setSection(section);
        mission.setTitle(title);
        mission.setSong1title(song1title);
        mission.setSong1level(song1level);
        mission.setSong1key(song1key);
        mission.setScoreLimit(scoreLimit);
        mission.setFeverLimit(feverLimit);
        mission.setComboLimit(comboLimit);
        mission.setRateLimit(rateLimit);
        mission.setBreakLimit(breakLimit);
        mission.setMore(more);
        mission.setReward(reward);
        mission.setSong2title(song2title);
        mission.setSong2level(song2level);
        mission.setSong2key(song2key);
        realm.commitTransaction();
    }

    void addMission(String type, String section, String title, String song1title, String song1level, String song1key, String song2title, String song2level, String song2key, String song3title, String song3level, String song3key, int scoreLimit, int feverLimit, int comboLimit, int rateLimit, int breakLimit, String more, String reward){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        MissionInfo mission=realm.createObject(MissionInfo.class);
        mission.setType(type);
        mission.setSection(section);
        mission.setTitle(title);
        mission.setSong1title(song1title);
        mission.setSong1level(song1level);
        mission.setSong1key(song1key);
        mission.setScoreLimit(scoreLimit);
        mission.setFeverLimit(feverLimit);
        mission.setComboLimit(comboLimit);
        mission.setRateLimit(rateLimit);
        mission.setBreakLimit(breakLimit);
        mission.setMore(more);
        mission.setReward(reward);
        mission.setSong2title(song2title);
        mission.setSong2level(song2level);
        mission.setSong2key(song2key);
        mission.setSong3title(song3title);
        mission.setSong3level(song3level);
        mission.setSong3key(song3key);
        realm.commitTransaction();
    }

    void addMission(String type, String section, String title, String song1title, String song1level, String song1key, String song2title, String song2level, String song2key, String song3title, String song3level, String song3key, String song4title, String song4level, String song4key, int scoreLimit, int feverLimit, int comboLimit, int rateLimit, int breakLimit, String more, String reward){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        MissionInfo mission=realm.createObject(MissionInfo.class);
        mission.setType(type);
        mission.setSection(section);
        mission.setTitle(title);
        mission.setSong1title(song1title);
        mission.setSong1level(song1level);
        mission.setSong1key(song1key);
        mission.setScoreLimit(scoreLimit);
        mission.setFeverLimit(feverLimit);
        mission.setComboLimit(comboLimit);
        mission.setRateLimit(rateLimit);
        mission.setBreakLimit(breakLimit);
        mission.setMore(more);
        mission.setReward(reward);
        mission.setSong2title(song2title);
        mission.setSong2level(song2level);
        mission.setSong2key(song2key);
        mission.setSong3title(song3title);
        mission.setSong3level(song3level);
        mission.setSong3key(song3key);
        mission.setSong4title(song4title);
        mission.setSong4level(song4level);
        mission.setSong4key(song4key);
        realm.commitTransaction();
    }

    void addMission(String type, String section, String title, String song1title, String song1level, String song1key, String song2title, String song2level, String song2key, String song3title, String song3level, String song3key, String song4title, String song4level, String song4key, String song5title, String song5level, String song5key, int scoreLimit, int feverLimit, int comboLimit, int rateLimit, int breakLimit, String more, String reward){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        MissionInfo mission=realm.createObject(MissionInfo.class);
        mission.setType(type);
        mission.setSection(section);
        mission.setTitle(title);
        mission.setSong1title(song1title);
        mission.setSong1level(song1level);
        mission.setSong1key(song1key);
        mission.setScoreLimit(scoreLimit);
        mission.setFeverLimit(feverLimit);
        mission.setComboLimit(comboLimit);
        mission.setRateLimit(rateLimit);
        mission.setBreakLimit(breakLimit);
        mission.setMore(more);
        mission.setReward(reward);
        mission.setSong2title(song2title);
        mission.setSong2level(song2level);
        mission.setSong2key(song2key);
        mission.setSong3title(song3title);
        mission.setSong3level(song3level);
        mission.setSong3key(song3key);
        mission.setSong4title(song4title);
        mission.setSong4level(song4level);
        mission.setSong4key(song4key);
        mission.setSong5title(song5title);
        mission.setSong5level(song5level);
        mission.setSong5key(song5key);
        realm.commitTransaction();
    }

    void addMission(String type, String section, String title, String song1title, String song1level, String song1key, String song2title, String song2level, String song2key, String song3title, String song3level, String song3key, String song4title, String song4level, String song4key, String song5title, String song5level, String song5key, String song6title, String song6level, String song6key, int scoreLimit, int feverLimit, int comboLimit, int rateLimit, int breakLimit, String more, String reward){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        MissionInfo mission=realm.createObject(MissionInfo.class);
        mission.setType(type);
        mission.setSection(section);
        mission.setTitle(title);
        mission.setSong1title(song1title);
        mission.setSong1level(song1level);
        mission.setSong1key(song1key);
        mission.setScoreLimit(scoreLimit);
        mission.setFeverLimit(feverLimit);
        mission.setComboLimit(comboLimit);
        mission.setRateLimit(rateLimit);
        mission.setBreakLimit(breakLimit);
        mission.setMore(more);
        mission.setReward(reward);
        mission.setSong2title(song2title);
        mission.setSong2level(song2level);
        mission.setSong2key(song2key);
        mission.setSong3title(song3title);
        mission.setSong3level(song3level);
        mission.setSong3key(song3key);
        mission.setSong4title(song4title);
        mission.setSong4level(song4level);
        mission.setSong4key(song4key);
        mission.setSong5title(song5title);
        mission.setSong5level(song5level);
        mission.setSong5key(song5key);
        mission.setSong6title(song6title);
        mission.setSong6level(song6level);
        mission.setSong6key(song6key);
        realm.commitTransaction();
    }

    void addTrophy(String series, String titleKor, String contentKor, String titleEng, String contentEng, String rating){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        TrophyInfo trophy=realm.createObject(TrophyInfo.class);
        trophy.setSeries(series);
        trophy.setTitleKor(titleKor);
        trophy.setTitleEng(titleEng);
        trophy.setContentEng(contentEng);
        trophy.setContentKor(contentKor);
        trophy.setRating(rating);
        realm.commitTransaction();
    }

    void addAchievement(String title, int level, String type, String item){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        AchievementInfo achievement=realm.createObject(AchievementInfo.class);
        achievement.setTitle(title);
        achievement.setLevel(level);
        achievement.setType(type);
        achievement.setItem(item);
        realm.commitTransaction();
    }

    float getSkillPoint(int difficulty, String rate, String note){
        if(difficulty == 0)
            return 0;
        float skillPoint = 0;
        final float e = 2.71828f;
        String rateString = rate.split("%")[0];
        float accuracy = 0;
        try{
            accuracy = Float.parseFloat(rateString);
        } catch (Exception a){
            accuracy = 0;
        }
        float weight = getWeight(difficulty);
        if(accuracy >= 80){
            float temp = (float)Math.pow((accuracy - 80) / 20, e) + 1;
            skillPoint = weight * 50 * temp;
        }
        else{
            skillPoint = weight * accuracy * 5 / 8;
        }
        if(note.equals("-") || note.equals(""))
            skillPoint = skillPoint * 0.98f;
        else if(note.equals("PERFECT PLAY"))
            skillPoint = skillPoint * 1.05f;
        skillPoint = Math.round(skillPoint * 100f) / 100f;
        return skillPoint;
    }

    float getWeight(int value){
        float result = 0f;
        switch(value){
            case 1:
                result = 0.4f;
                break;
            case 2:
                result = 0.6f;
                break;
            case 3:
                result = 0.8f;
                break;
            case 4:
                result = 1f;
                break;
            case 5:
                result = 1.14f;
                break;
            case 6:
                result = 1.24f;
                break;
            case 7:
                result = 1.33f;
                break;
            case 8:
                result = 1.42f;
                break;
            case 9:
                result = 1.53f;
                break;
            case 10:
                result = 1.6f;
                break;
            case 11:
                result = 1.68f;
                break;
            case 12:
                result = 1.77f;
                break;
            case 13:
                result = 1.85f;
                break;
            case 14:
                result = 1.94f;
                break;
            case 15:
                result = 2f;
            default:
                break;
        }
        return result;
    }
}





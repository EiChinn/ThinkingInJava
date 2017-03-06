package com.eichinn.holding.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Arrays.asList() makes ites best guess about type.
 * Created by ei_chinn on 2017/2/28.
 */
public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());

        List<Snow> snow2 = Arrays.<Snow>asList(new Light(), new Heavy());

        List<Snow> snow3 = Arrays.<Snow>asList(new Light(), new Heavy());

        List<Snow> snow4 = new ArrayList<>();
        Collections.addAll(snow3, new Light(), new Heavy());


    }
}

class Snow {

}
class Powder extends Snow {

}

class Light extends Powder {

}

class Heavy extends Powder {

}

class Crusty extends Snow {

}

class Slush extends Snow {

}


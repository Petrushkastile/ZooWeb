package Databases;

public class Animal {
 String TYPE_OF_ANIMAL=new String(  );
 String NAME_ANIMAL=new String(  );
 String AGE_ANIMAL=new String(  );

    public void setTYPE_OF_ANIMAL(String TYPE_OF_ANIMAL) {
        this.TYPE_OF_ANIMAL = TYPE_OF_ANIMAL;
    }

    public void setNAME_ANIMAL(String NAME_ANIMAL) {
        this.NAME_ANIMAL = NAME_ANIMAL;
    }

    public void setAGE_ANIMAL(String AGE_ANIMAL) {
        this.AGE_ANIMAL = AGE_ANIMAL;
    }

    public String getTYPE_OF_ANIMAL() {
        return TYPE_OF_ANIMAL;
    }

    public String getNAME_ANIMAL() {
        return NAME_ANIMAL;
    }

    public String getAGE_ANIMAL() {
        return AGE_ANIMAL;
    }

    @Override
    public String toString() {
        return TYPE_OF_ANIMAL+" "+NAME_ANIMAL+" "+AGE_ANIMAL;
    }

}
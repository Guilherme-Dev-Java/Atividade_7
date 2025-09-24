import java.util.ArrayList;
import java.util.List;

interface IMeioTransporte {
    void acelerar();
    void frear();
}

class Carro implements IMeioTransporte {
    private int velocidade = 0;

    public void acelerar() {
        if (velocidade >= 200) {
            throw new IllegalStateException("Carro já está na velocidade máxima");
        }
        velocidade += 20;
        System.out.println("Carro acelerando: " + velocidade + " km/h");
    }

    public void frear() {
        if (velocidade <= 0) {
            throw new IllegalStateException("Carro já está parado");
        }
        velocidade -= 20;
        System.out.println("Carro freando: " + velocidade + " km/h");
    }
}

class Bicicleta implements IMeioTransporte {
    private int velocidade = 0;

    public void acelerar() {
        if (velocidade >= 40) {
            throw new IllegalStateException("Bicicleta já está na velocidade máxima");
        }
        velocidade += 5;
        System.out.println("Bicicleta acelerando: " + velocidade + " km/h");
    }

    public void frear() {
        if (velocidade <= 0) {
            throw new IllegalStateException("Bicicleta já está parada");
        }
        velocidade -= 5;
        System.out.println("Bicicleta freando: " + velocidade + " km/h");
    }
}

class Trem implements IMeioTransporte {
    private int velocidade = 0;

    public void acelerar() {
        if (velocidade >= 300) {
            throw new IllegalStateException("Trem já está na velocidade máxima");
        }
        velocidade += 50;
        System.out.println("Trem acelerando: " + velocidade + " km/h");
    }

    public void frear() {
        if (velocidade <= 0) {
            throw new IllegalStateException("Trem já está parado");
        }
        velocidade -= 50;
        System.out.println("Trem freando: " + velocidade + " km/h");
    }
}

public class Exercicio4MeioTransporte {
    public static void main(String[] args) {
        List<IMeioTransporte> transportes = new ArrayList<>();
        transportes.add(new Carro());
        transportes.add(new Bicicleta());
        transportes.add(new Trem());

        for (IMeioTransporte t : transportes) {
            t.acelerar();
            t.acelerar();
            t.frear();
        }
    }
}

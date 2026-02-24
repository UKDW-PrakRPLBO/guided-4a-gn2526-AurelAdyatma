package com.rplbo.projectrekeninginheritance;

public class RekeningKeluarga extends Rekening {

    public RekeningKeluarga(Nasabah nasabah) {
        super(nasabah);
    }

    public RekeningKeluarga(Nasabah nasabah, int saldo) {
        super(nasabah, saldo);
    }

    @Override
    public void penyetoran(int jumlah) {
        if (jumlah > 0) {
            int total = jumlah + (int) bunga(jumlah);
            setSaldo(getSaldo() + total);
        }
    }

    private double bunga(int jumlah) {
        return jumlah * 0.005; // 0.5%
    }

    @Override
    public void penarikan(int jumlah) {
        if (jumlah > 0 && jumlah <= getSaldo()) {
            setSaldo(getSaldo() - jumlah);
        } else {
            System.out.println("Saldo tidak mencukupi!");
        }
    }
}
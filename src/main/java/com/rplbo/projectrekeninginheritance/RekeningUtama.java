package com.rplbo.projectrekeninginheritance;

public class RekeningUtama extends Rekening {

    private static final int BATAS_PENARIKAN = 3000000;
    private static final int BIAYA_ADMIN = 5000;

    public RekeningUtama(Nasabah nasabah) {
        super(nasabah);
    }

    public RekeningUtama(Nasabah nasabah, int saldo) {
        super(nasabah, saldo);
    }

    // Penyetoran + bunga 0.5%
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

    // Penarikan: max 3.000.000 + admin 5.000
    @Override
    public void penarikan(int jumlah) {
        if (jumlah <= 0) return;

        if (jumlah > BATAS_PENARIKAN) {
            System.out.println("Penarikan melebihi batas rekening utama!");
            return;
        }

        int total = jumlah + BIAYA_ADMIN;
        if (total <= getSaldo()) {
            setSaldo(getSaldo() - total);
        } else {
            System.out.println("Saldo tidak mencukupi!");
        }
    }
}
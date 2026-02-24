package com.rplbo.projectrekeninginheritance;

public class RekeningTambahan extends Rekening {

    private static final int BATAS_PENARIKAN = 500000;
    private static final int BIAYA_ADMIN = 5000;

    public RekeningTambahan(Nasabah nasabah) {
        super(nasabah);
    }

    public RekeningTambahan(Nasabah nasabah, int saldo) {
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

    // Penarikan: max 500.000 + admin 5.000
    @Override
    public void penarikan(int jumlah) {
        if (jumlah <= 0) return;

        if (jumlah > BATAS_PENARIKAN) {
            System.out.println("Penarikan melebihi batas rekening tambahan!");
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

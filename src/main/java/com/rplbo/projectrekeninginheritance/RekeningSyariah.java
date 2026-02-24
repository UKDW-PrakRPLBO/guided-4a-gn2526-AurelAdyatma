package com.rplbo.projectrekeninginheritance;

public class RekeningSyariah extends Rekening {

    public RekeningSyariah(Nasabah nasabah) {
        super(nasabah);
    }

    public RekeningSyariah(Nasabah nasabah, int saldo) {
        super(nasabah, saldo);
    }

    // Penyetoran TANPA bunga
    @Override
    public void penyetoran(int jumlah) {
        if (jumlah > 0) {
            setSaldo(getSaldo() + jumlah);
        }
    }

    // Penarikan: >100000 admin 1000, <=100000 admin 0
    @Override
    public void penarikan(int jumlah) {
        if (jumlah <= 0) return;

        int biayaAdmin = (jumlah > 100000) ? 1000 : 0;
        int total = jumlah + biayaAdmin;

        if (total <= getSaldo()) {
            setSaldo(getSaldo() - total);
        } else {
            System.out.println("Saldo tidak mencukupi!");
        }
    }

    // Sedekah: potong saldo jika cukup
    public void sedekah(int nominal) {
        if (nominal <= 0) return;

        if (nominal <= getSaldo()) {
            setSaldo(getSaldo() - nominal);
        } else {
            System.out.println("Saldo tidak mencukupi untuk sedekah!");
        }
    }
}
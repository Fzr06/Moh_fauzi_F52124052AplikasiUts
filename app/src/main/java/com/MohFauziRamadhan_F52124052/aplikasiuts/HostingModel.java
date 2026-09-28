package com.MohFauziRamadhan_F52124052.aplikasiuts;

public class HostingModel {
    private String namaHosting;
    private String keterangan;
    private String website;
    private int gambar;

    public HostingModel(String namaHosting, String keterangan, String website, int gambar) {
        this.namaHosting = namaHosting;
        this.keterangan = keterangan;
        this.website = website;
        this.gambar = gambar;
    }

    public String getNamaHosting() {
        return namaHosting;
    }

    public void setNamaHosting(String namaHosting) {
        this.namaHosting = namaHosting;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}

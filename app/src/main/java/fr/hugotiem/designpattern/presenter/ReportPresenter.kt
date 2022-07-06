package fr.hugotiem.designpattern.presenter

import fr.hugotiem.designpattern.model.Report

class ReportPresenter(val model: Report) {
    fun loadData() {
        return model.fetchDetails()
    }
}
//
//  DetailView.swift
//  Ohami Core
//
//  Created by Sean Najera on 4/26/20.
//  Copyright © 2020 Sean Najera. All rights reserved.
//
import SwiftUI
import MarianaKit

struct DetailView: View {
    
    let location: Location

    var body: some View {
        VStack {
            Text(location.name ?? "Location-\(location.id)").font(.largeTitle)
            Text(location.regionResponse?.name ?? "N/A").font(.subheadline)
            Text(location.addressLine1 ?? "N/A").font(.subheadline)
            Text(location.phoneNumber ?? "N/A").font(.subheadline)
        }
    }
}

//
//  ContentView.swift
//  Ohami Core
//
//  Created by Sean Najera on 4/26/20.
//  Copyright © 2020 Sean Najera. All rights reserved.
//

import SwiftUI
import MarianaKit

struct ContentView: View {

    let msg = ActualKt.platformName()
    
    var body: some View {
        NavigationView {
                TabView {
                    NavigationLink(destination: DetailView(discipline: "20,000 Leagues Under The Sea"), label: {
                        Text("Kotlin Rocks on \(msg)")
                    })
                        .tabItem {
                        Image(systemName: "1.square.fill")
                        Text("First")
                    }
                
                }.navigationBarTitle("Nautilus")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

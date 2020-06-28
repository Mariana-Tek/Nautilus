//
//  ContentView.swift
//  Ohami Core
//
//  Created by Sean Najera on 4/26/20.
//  Copyright © 2020 Sean Najera. All rights reserved.
//

import SwiftUI
import Nautilus

struct ContentView: View {

    let msg = CommonKt.createApplicationScreenMessage()
    
    var body: some View {
        NavigationView {
            TabView {
                NavigationLink(destination: DetailView(discipline: "Steam"), label: {
                    Text("The First Tab: \(msg)")
                })
                    .tabItem {
                    Image(systemName: "1.square.fill")
                    Text("First")
                }
                Text("Another Tab: \(msg)")
                    .tabItem {
                        Image(systemName: "2.square.fill")
                        Text("Second")
                    }
                Text("The Last Tab: \(msg)")
                    .tabItem {
                        Image(systemName: "3.square.fill")
                        Text("Third")
                    }
            }.navigationBarTitle("Disciplines")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

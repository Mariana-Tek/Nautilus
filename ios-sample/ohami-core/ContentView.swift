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
    let mariana = Mariana()
    @State var locations: Array<Location> = []
    
    var body: some View {
        NavigationView {
            List {
                ForEach(locations,  id: \.id) { location in
                    NavigationLink(destination: DetailView(location: location), label: {
                        Text(location.name ?? "Location-\(location.id)")
                    }).navigationBarTitle(Text("Kotlin Rocks on \(msg)"), displayMode: .large)
                }
            }
        }.onAppear(perform: fetchLocations)
    }
    
    private func fetchLocations() {
        DispatchQueue.main.asyncAfter(deadline: .now()) {
            let locationsCall = mariana.getLocations()
            
            locationsCall.get { completion in
                switch (completion) {
                case let locationsData as ResultTypeSuccess<AnyObject>:
                    guard let locations = locationsData.data as? Array<Location> else {
                        return
                    }
                    
                    self.locations = locations
                    
                    break
                case _ as ResultTypeFailure<AnyObject>:
                    // Handle Error
                    break
                default:
                    break
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

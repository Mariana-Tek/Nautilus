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
  
    @State var locationName: String = ""
    
    let mariana = Mariana()

    var body: some View {
        Text(locationName)
            .onAppear(perform: execute)
    }
    
    private func execute() {
        DispatchQueue.main.asyncAfter(deadline: .now()) {
            let locationsCall = mariana.getLocations()
            
            locationsCall.get { completion in
                guard let locationData = completion as? ResultTypeSuccess<AnyObject>,
                      let locations = locationData.data as? Array<Location> else {
                    
                    
                    return
                }
                
                self.locationName = locations.first?.name ?? "First Location"
            }
        }
    }
}

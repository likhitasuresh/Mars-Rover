# Mars-Rover
This is a Java application that takes inputs and determines if the Mars rover can successfully reach its destination.

Dated: September 2019.

## Objective
This project aims at using different search algorithms to provide paths from the specified landing spot to various specified destinations.

## Highlights
* The rover cannot climb steep hills or descent into deep pits, which, in this project, is denoted by the difference in elevation.
* The rover can move in eight possible directions - N, E, W, S, NE, NW, SE, SW, one step at a time.
* The landscape is denoted by a two dimensional matrix, with indices as coordinates and values as difference in elevation, which can also be considered z coordinate.
* The three search algorithms implemented are Breadth First Search, Uniform Cost Search, A* Search.

## Input format
* Search Algorithm - BFS/UCS/A*
* Width Height (of map matrix)
* X Y coordinates of the landing site
* Number of target sites
* X Y coordinates for different target sites (mentioned on seperate lines)
* Map matrix

object MarsRover {

  case class Location(x: Int, y: Int, orientation: Char)
  /**
   * Helper function to handle the orientation position of the robot
   * @param currentOrientation
   * @param currentStep
   * @return the new orientation of the robot
   */
  def handleRotation(currentOrientation: Char, currentStep: Char): Char = (currentStep, currentOrientation) match {

    case (o, _) if o == 'F' => currentOrientation
    case (o, s) if o == 'N' && s == 'R' => 'E'
    case (o, s) if o == 'N' && s == 'L' => 'W'
    case (o, s) if o == 'E' && s == 'R' => 'S'
    case (o, s) if o == 'E' && s == 'L' => 'N'
    case (o, s) if o == 'S' && s == 'R' => 'W'
    case (o, s) if o == 'S' && s == 'L' => 'E'
    case (o, s) if o == 'W' && s == 'R' => 'N'
    case (o, s) if o == 'W' && s == 'L' => 'S'
  }

  /**
   * Helper function handling the new position of x according to the step and the orientation
   * @param x
   * @param currentOrientation
   * @param currentStep
   * @return the new position of x
   */
  def handleMoveX(x: Int, currentOrientation: Char, currentStep: Char): Int = (currentOrientation, currentStep) match {
    case (o, _) if o == 'R' || o == 'L' => x
    case (o, s) if o == 'N' && s == 'F' => x
    case (o, s) if o == 'S' && s == 'F' => x
    case (o, s) if o == 'E' && s == 'F' => x + 1
    case (o, s) if o == 'W' && s == 'F' => x - 1
  }

  /**
   * Helper function handling the new position of y according to the step and the orientation
   * @param y
   * @param currentOrientation
   * @param currentStep
   * @return the new position of y
   */
  def handleMoveY(y: Int, currentOrientation: Char, currentStep: Char): Int = (currentOrientation, currentStep) match {
    case (o, _) if o == 'R' || o == 'L' => y
    case (o, s) if o == 'N' && s == 'F' => y + 1
    case (o, s) if o == 'S' && s == 'F' => y - 1
    case (o, s) if o == 'E' && s == 'F' => y
    case (o, s) if o == 'W' && s == 'F' => y
  }

  /**
   * Core function updating the robots positions according to their initial position, their orientation,
   * and the steps they have to do within a specific grid.
   * If the robot is out of the grid, we should see LOST in the result and the final state should be its last valid position.
   * @param current
   * @param last
   * @param xMax
   * @param yMax
   * @param steps
   * @return the final state of the robot.
   */
  def marsRover(current: Location, last: Location, xMax: Int, yMax: Int, steps: List[Char]): String = {
    // base cases
    if (current.x < 0 || current.y < 0 || current.x > xMax || current.y > yMax) {
      return (f"${last.x}, ${last.y}, ${last.orientation} LOST")
    }
    if (steps.isEmpty) {
      f"${current.x}, ${current.y}, ${current.orientation}"
    }
    else {
      // recursive call until steps are empty or if the robot is out of the grid
      marsRover(
        Location(handleMoveX(current.x, current.orientation, steps.head),
          handleMoveY(current.y, current.orientation, steps.head),
          handleRotation(current.orientation, steps.head)),
        current,
        xMax,
        yMax,
        steps.tail
      )
    }
  }


  def main(args: Array[String]): Unit = {
    val currentLocation = Location(0, 0, 'N')
    val moves = "FFFFF"
    val result = marsRover(
      currentLocation, currentLocation, 4, 4, moves.toList
    )
    println(result)
  }
}




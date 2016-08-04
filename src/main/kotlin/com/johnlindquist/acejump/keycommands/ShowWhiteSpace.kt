package com.johnlindquist.acejump.keycommands

import com.johnlindquist.acejump.AceFinder
import com.johnlindquist.acejump.ui.SearchBox
import java.awt.event.KeyEvent
import javax.swing.event.ChangeListener

class ShowWhiteSpace(override val searchBox: SearchBox, override val aceFinder: AceFinder) : AceKeyCommand() {
  init {
    addListener(defaultChangeListener)
  }
  
  override fun execute(keyEvent: KeyEvent) {
    aceFinder.addResultsReadyListener(ChangeListener { p0 ->
      eventDispatcher.multicaster.stateChanged(p0)
    })

    aceFinder.findText(AceFinder.WHITE_SPACE, true)
    searchBox.forceSpaceChar()
  }
}
package com.company.myapiadminx.screen.vworkprogram;

import io.jmix.ui.screen.*;
import com.company.myapiadminx.entity.VWorkProgram;

@UiController("VWorkProgram.browse")
@UiDescriptor("v-work-program-browse.xml")
@LookupComponent("vWorkProgramsTable")
public class VWorkProgramBrowse extends StandardLookup<VWorkProgram> {
}
/////////////////////////////////////////////////////////////////////////////////////////
//                 University of Luxembourg  - 
//                 Interdisciplinary center for Security and Trust (SnT)
//                 Copyright © 2016 University of Luxembourg, SnT
// 
//  
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 3 of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//
//
//    Author: Matthieu Jimenez – SnT – matthieu.jimenez@uni.lu 
//
//////////////////////////////////////////////////////////////////////////////////////////
package lu.jimenez.research.bugsandvulnerabilities.model.extension

import lu.jimenez.research.bugsandvulnerabilities.model.BuggyFile
import lu.jimenez.research.bugsandvulnerabilities.model.VulnerableFile
import lu.jimenez.research.bugsandvulnerabilities.model.internal.Document

import java.util.*

/**
 * Object containing utilitary methods
 */
object UtilitaryMethods {
    /**
     * Method to create a set of all the different file present in a list of FileData
     *
     * @param listfiles: list of file data
     *
     * @return set of files
     */
    fun listofFiles(listfiles: List<Document>): Set<String> {
        val setfiles = HashSet<String>()
        for (file in listfiles) {
            setfiles.add(file.fullPath)
        }
        return setfiles
    }

    /**
     * Method returning the list of all the files that are present in the vulnerable and the buggy set
     *
     * @param listBug list of buggy files (might be null)
     * @param listVuln list of Vulnerable files
     *
     * @return set of filename
     */
    fun setOfAlreadyPresentFiles(listVuln: List<VulnerableFile>, listBug: List<BuggyFile>? = null): Set<String> {
        val setfiles = HashSet<String>()
        for (vuln in listVuln) {
            setfiles.add(vuln.patchedFile.fullPath)
            setfiles.add(vuln.vulnerableFile.fullPath)
        }
        if (listBug != null) {
            for (bug in listBug) {
                setfiles.add(bug.patchedFile.fullPath)
                setfiles.add(bug.buggyFile.fullPath)
            }
        }
        return setfiles
    }

    /**
     *Method to retrieve all the commit mentionned in a list of vulnerable File
     *
     * @param listVuln list of vulnerable file
     *
     * @return map of Hash and the number of times they occur
     */
    fun setOfCommitPatchVulnerability(listVuln: List<VulnerableFile>): Map<String,Int> {
        val setCommit = mutableMapOf<String,Int>()
        for (vuln in listVuln) {
            setCommit[vuln.patchedFile.commitHash] = (setCommit[vuln.patchedFile.commitHash] ?:0) +1
        }
        return setCommit
    }


}
 
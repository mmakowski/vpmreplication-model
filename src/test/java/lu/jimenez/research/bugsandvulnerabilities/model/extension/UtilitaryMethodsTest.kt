package lu.jimenez.research.bugsandvulnerabilities.model.extension

import lu.jimenez.research.bugsandvulnerabilities.model.BuggyFile
import lu.jimenez.research.bugsandvulnerabilities.model.VulnerableFile
import lu.jimenez.research.bugsandvulnerabilities.model.internal.Document
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldEqual

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

class UtilitaryMethodsTest : Spek() {
    init {
        //List of path
        given("a list of file data containing two file with the same path") {
            val file = Document("file.c", 1230000, "ae80000", "content")

            val list = listOf(file, file)
            on("extracting the set of path") {
                val result = UtilitaryMethods.listofFiles(list)
                it("should return a set of size 1") {
                    assert(result.size == 1)
                }
            }

        }
        given("a list of file data containing two file with the different path") {
            val file = Document("file.c", 1230000, "ae80000", "content")
            val file2 = Document("file2.c", 1230000, "ae80000", "content")

            val list = listOf(file, file2)
            on("exctrating the set of path") {
                val result = UtilitaryMethods.listofFiles(list)
                it("should return a set of size 2") {
                    assert(result.size == 2)
                }
            }

        }
        given(" a list of two vulnerable Files from separate commit") {
            var listvuln = mutableListOf<VulnerableFile>()
            val filevuln1 = Document("file.c", 1230000, "ae80000", "content")
            val filepatch1 = Document("file2.c", 1230000, "ae80001", "content+")
            val filevuln2 = Document("file.c", 1230000, "ae80002", "content")
            val filepatch2 = Document("file.c", 1230000, "ae8003", "content+")
            listvuln.add(VulnerableFile(filevuln1, filepatch1, "t", false))
            listvuln.add(VulnerableFile(filevuln2, filepatch2, "t", false))
            on("computing the list of commit hash") {
                val result = UtilitaryMethods.setOfCommitPatchVulnerability(listvuln)
                it("should return a list of size 2"){
                    shouldEqual(2,result.size)
                }
            }
            on("adding a vulnerable file from the same commit and computing the list of commit hash"){
                val filevuln3 = Document("file4.c", 1230000, "ae80005", "content")
                val filepatch3 = Document("file4.c", 1230000, "ae80001", "content+")
                listvuln.add(VulnerableFile(filevuln3, filepatch3, "t", false))
                val result = UtilitaryMethods.setOfCommitPatchVulnerability(listvuln)
                it("should still return a list of size 2"){
                    shouldEqual(2,result.size)
                }
            }
            on("computing the list of files"){
                val result = UtilitaryMethods.setOfAlreadyPresentFiles(listvuln)
                it("should return a list of size 3"){
                    shouldEqual(3,result.size)
                }
            }
            on("computing the list of file with a bug file list"){
                var listbug = mutableListOf<BuggyFile>()
                val filebug = Document("file3.c", 1230000, "ae80000", "content")
                val filepatchbug = Document("file4.c", 1230000, "ae80001", "content+")
                listbug.add(BuggyFile(filebug,filepatchbug,"",""))
                val result = UtilitaryMethods.setOfAlreadyPresentFiles(listvuln,listbug)
                it("should return a list of size 4"){
                    shouldEqual(4,result.size)
                }
            }
        }
    }
}